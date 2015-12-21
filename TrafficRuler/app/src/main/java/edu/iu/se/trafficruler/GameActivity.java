package edu.iu.se.trafficruler;

import android.content.Intent;
import android.graphics.Typeface;
import android.util.Log;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.FixtureDef;

import org.andengine.engine.camera.ZoomCamera;
import org.andengine.engine.camera.hud.HUD;
import org.andengine.engine.camera.hud.controls.AnalogOnScreenControl;
import org.andengine.engine.camera.hud.controls.BaseOnScreenControl;
import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.SpriteBackground;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.shape.IAreaShape;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.sprite.TiledSprite;
import org.andengine.entity.text.Text;
import org.andengine.entity.util.FPSLogger;
import org.andengine.extension.physics.box2d.FixedStepPhysicsWorld;
import org.andengine.extension.physics.box2d.PhysicsConnector;
import org.andengine.extension.physics.box2d.PhysicsFactory;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import org.andengine.extension.physics.box2d.util.Vector2Pool;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.ui.activity.SimpleBaseGameActivity;
import org.andengine.util.color.Color;
import org.andengine.util.debug.Debug;
import org.andengine.util.math.MathUtils;

import edu.iu.se.trafficruler.Signal.ScoreManager;
import edu.iu.se.trafficruler.Signal.SignalHandler;
import edu.iu.se.trafficruler.UserOptions.GameConfig;
import edu.iu.se.trafficruler.UserOptions.UserSelection;


public class GameActivity extends SimpleBaseGameActivity implements MenuScene.IOnMenuItemClickListener {

    private static final int RACETRACK_WIDTH = 64;
    private static final int CAR_SIZE = 32;
    private static final int CAMERA_WIDTH = RACETRACK_WIDTH * 15;
    private static final int CAMERA_HEIGHT = RACETRACK_WIDTH * 9;
    private Scene scene;
    private PhysicsWorld mPhysicsWorld;
    private BitmapTextureAtlas mVehiclesTexture;
    private TextureRegion mVehiclesTextureRegion;
    private BitmapTextureAtlas mCenterBoardTexture;
    private TextureRegion mCenterBoardTextureRegion;
    private Body mCarBody;
    private Sprite mCar;
    private ZoomCamera mCamera;
    private BitmapTextureAtlas mFontTexture;
    private BitmapTextureAtlas mFontTextureInst;
    private HUD hud;
    private Text scoreText;
    private Text modeText;
    private Text displayInst;
    private Font mFont;
    private Font mFontInst;
    private BitmapTextureAtlas mRacetrackTexture;
    private TextureRegion mRacetrackStraightTextureRegion;
    private TextureRegion mRacetrackCurveTextureRegion;
    private BitmapTextureAtlas mStopSignalTexture;
    private TextureRegion mStopSignalTextureRegion;
    private BitmapTextureAtlas mOnScreenControlTexture;
    private TextureRegion mOnScreenControlBaseTextureRegion;
    private TextureRegion mOnScreenControlKnobTextureRegion;
    private BitmapTextureAtlas mPauseButtonTexture;
    private TextureRegion mPauseButtonTextureTextureRegion;
    private BitmapTextureAtlas gameBackgroundTexture;
    private TextureRegion gameTextureRegion;
    private Sprite signalRTop;
    private Body signalRTopBody;
    private Sprite signalLTop;
    private Body signalLTopBody;
    private Sprite signalRBottom;
    private Body signalRBottomBody;
    private Sprite signalLBottom;
    private Body signalLBottomBody;


    private SignalHandler signalHandler;

    @Override
    protected void onCreateResources() {
        try {


            BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");

            this.mVehiclesTexture = new BitmapTextureAtlas(getTextureManager(), 128, 64, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
            this.mVehiclesTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mVehiclesTexture, this, UserSelection.getVehicleImageName(), 0, 0);

            this.mCenterBoardTexture = new BitmapTextureAtlas(getTextureManager(), 256, 64, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
            this.mCenterBoardTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mCenterBoardTexture, this, "menu_ok.png", 0, 0);

            this.mRacetrackTexture = new BitmapTextureAtlas(getTextureManager(), 128, 256, TextureOptions.REPEATING_BILINEAR_PREMULTIPLYALPHA);
            this.mRacetrackStraightTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mRacetrackTexture, this, "racetrack_straight.png", 0, 0);
            this.mRacetrackCurveTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mRacetrackTexture, this, "racetrack_curve.png", 0, 128);

            this.mStopSignalTexture = new BitmapTextureAtlas(getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
            this.mStopSignalTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mStopSignalTexture, this, "stop_signal.png", 0, 128);

            this.mPauseButtonTexture = new BitmapTextureAtlas(getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
            this.mPauseButtonTextureTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mPauseButtonTexture, this, "pause.png", 0, 128);

            gameBackgroundTexture = new BitmapTextureAtlas(getTextureManager(), 2048, 1024, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
            gameTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.gameBackgroundTexture, this, "background.png", 0, 0);

            this.mEngine.getTextureManager().loadTexture(this.gameBackgroundTexture);
            this.mOnScreenControlTexture = new BitmapTextureAtlas(getTextureManager(), 256, 128, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
            this.mOnScreenControlBaseTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mOnScreenControlTexture, this, "onscreen_control_base.png", 0, 0);
            this.mOnScreenControlKnobTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mOnScreenControlTexture, this, "onscreen_control_knob.png", 128, 0);
            this.mEngine.getTextureManager().loadTexture(this.mOnScreenControlTexture);
            this.mEngine.getTextureManager().loadTexture(this.mVehiclesTexture);
            this.mEngine.getTextureManager().loadTexture(this.mRacetrackTexture);
            this.mEngine.getTextureManager().loadTexture(this.mStopSignalTexture);

            this.mFontTexture = new BitmapTextureAtlas(getTextureManager(), 256, 256, TextureOptions.BILINEAR);
            this.mFont = new Font(getFontManager(), this.mFontTexture, Typeface.create(Typeface.SERIF, Typeface.BOLD), 32, true, Color.CYAN);
            // Instructions Font
            this.mFontTextureInst = new BitmapTextureAtlas(getTextureManager(), 256, 256, TextureOptions.BILINEAR);
            this.mFontInst = new Font(getFontManager(), this.mFontTextureInst, Typeface.create(Typeface.SERIF, Typeface.BOLD), 20, true, Color.YELLOW);

            this.mEngine.getTextureManager().loadTexture(this.mCenterBoardTexture);
            this.mEngine.getTextureManager().loadTexture(this.mFontTexture);
            this.mEngine.getTextureManager().loadTexture(this.mFontTextureInst);
            this.mEngine.getFontManager().loadFont(this.mFont);
            this.mEngine.getFontManager().loadFont(this.mFontInst);
            this.mEngine.getTextureManager().loadTexture(this.mPauseButtonTexture);
            signalHandler = new SignalHandler(mStopSignalTexture, mStopSignalTextureRegion, this);
//            musicPlayer = new MusicPlayer(this);
//            musicPlayer.playMusic();
        } catch (Exception e) {
            Debug.e(e);
        }
    }

    private ContactListener createContactListener() {
        return signalHandler.getContactListener();
    }


    @Override
    protected Scene onCreateScene() {
        this.mEngine.registerUpdateHandler(new FPSLogger());
        this.scene = new Scene();
        this.hud = new HUD();
        SpriteBackground background = new SpriteBackground(new Sprite(0, 0, gameTextureRegion, getVertexBufferObjectManager()));
        this.scene.setBackground(background);
        this.mPhysicsWorld = new FixedStepPhysicsWorld(30, new Vector2(0, 0), false, 8, 1);
        this.initTracks();
        this.intitBorders();
        this.initCar();
        this.initOnScreenControls();
        this.scene.registerUpdateHandler(this.mPhysicsWorld);
        this.addPauseButton();
        this.scene.registerUpdateHandler(new TimedScreenUpdateHandler(5, new ITimerCallback() {
            @Override
            public void onTimePassed(TimerHandler pTimerHandler) {
                signalHandler.changeSignal();

            }
        }));
        createScoreText();
        createModeText();
        if (GameConfig.getGameMode() == GameConfig.GameMode.Practise || GameConfig.getGameMode() == GameConfig.GameMode.Time){
            displayInstructions();
        }
        this.mPhysicsWorld.setContactListener(createContactListener());
        initSignal();
        return this.scene;
    }

    public void addPauseButton() {
        final Sprite pauseButton = new Sprite(CAMERA_WIDTH - 40, 30, 30, 30, mPauseButtonTextureTextureRegion, getVertexBufferObjectManager()) {
            @Override
            public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {

                if (pSceneTouchEvent.isActionDown()) {
                    Intent intent = new Intent(getApplicationContext(), Pause_Game.class);
                    startActivity(intent);
                    return false;
                } else {
                    scene.clearChildScene();
                    mPauseButtonTexture.clearTextureAtlasSources();
                    mPauseButtonTextureTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mPauseButtonTexture, getApplicationContext(), "resume.png", 0, 128);
                    return false;
                }
            }
        };
        hud.registerTouchArea(pauseButton);
        hud.attachChild(pauseButton);
    }

    private void createScoreText() {
        scoreText = new Text(CAMERA_WIDTH / 2 - 20, 50, this.mFont, "Game Over, Score: 0123456789", 30, getVertexBufferObjectManager());

        scoreText.setText("Score 0");
        scoreText.setScale(1.2F);

        hud.attachChild(scoreText);

        this.mCamera.setHUD(hud);
        ScoreManager.setScoreText(scoreText);
    }

    private void createModeText() {
        modeText = new Text(20, 50, this.mFont, "Practise Mode", 30, getVertexBufferObjectManager());
        modeText.setText(GameConfig.getGameMode().gameModeString());
        modeText.setScale(0.8F);
        hud.attachChild(modeText);
        ScoreManager.setScoreText(scoreText);
    }

    public void displayInstructions(){
        displayInst = new Text(CAMERA_WIDTH / 2 - 80 ,100, this.mFontInst,"Keep Driving" ,50, getVertexBufferObjectManager());
        if(GameConfig.getGameMode() == GameConfig.GameMode.Time)
        {
            displayInst.setText("Cross all the signals in 2 minute");
        }
        displayInst.setScale(1.2F);
        hud.attachChild(displayInst);
        SignalHandler.setInstText(displayInst);
    }

    private void initOnScreenControls() {
        final AnalogOnScreenControl analogOnScreenControl = new AnalogOnScreenControl(CAMERA_WIDTH / 2, CAMERA_HEIGHT - this.mOnScreenControlTexture.getHeight() - 30, this.mCamera, this.mOnScreenControlBaseTextureRegion, this.mOnScreenControlKnobTextureRegion, 0.1f, getVertexBufferObjectManager(), new AnalogOnScreenControl.IAnalogOnScreenControlListener() {
            @Override
            public void onControlClick(AnalogOnScreenControl pAnalogOnScreenControl) {
            }

            @Override
            public void onControlChange(BaseOnScreenControl pBaseOnScreenControl, float pValueX, float pValueY) {
                final Body carBody = GameActivity.this.mCarBody;
                final Vector2 velocity = Vector2Pool.obtain(pValueX * 5, pValueY * 5);
                carBody.setLinearVelocity(velocity);
                Vector2Pool.recycle(velocity);
                final float rotationInRad = (float) Math.atan2(-pValueX, pValueY);
                carBody.setTransform(carBody.getWorldCenter(), rotationInRad);
                GameActivity.this.mCar.setRotation(MathUtils.radToDeg(rotationInRad));
            }
        });
        analogOnScreenControl.getControlBase().setAlpha(0.5f);
        analogOnScreenControl.getControlBase().setScaleCenter(0, 128);
        analogOnScreenControl.getControlBase().setScale(0.75f);
        analogOnScreenControl.getControlKnob().setScale(0.75f);
        analogOnScreenControl.refreshControlKnobPosition();

        this.scene.setChildScene(analogOnScreenControl);
    }

    private void initSignal() {
        final FixtureDef signalFixureTR = PhysicsFactory.createFixtureDef(0, 0, 0);
        signalFixureTR.isSensor = true;
        this.signalRTopBody = PhysicsFactory.createBoxBody(this.mPhysicsWorld, signalRTop, BodyDef.BodyType.StaticBody, signalFixureTR);
        this.signalRTopBody.setUserData("signalA");
        this.signalRTop.setUserData("signalA");
        this.mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(this.signalRTop, this.signalRTopBody, true, false));

        final FixtureDef signalFixureTL = PhysicsFactory.createFixtureDef(0, 0, 0);
        signalFixureTL.isSensor = true;
        this.signalLTopBody = PhysicsFactory.createBoxBody(this.mPhysicsWorld, signalLTop, BodyDef.BodyType.StaticBody, signalFixureTL);
        this.signalLTopBody.setUserData("signalB");
        this.signalLTop.setUserData("signalB");
        this.mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(this.signalLTop, this.signalLTopBody, true, false));

        final FixtureDef signalFixureBL = PhysicsFactory.createFixtureDef(0, 0, 0);
        signalFixureBL.isSensor = true;
        this.signalLBottomBody = PhysicsFactory.createBoxBody(this.mPhysicsWorld, signalLBottom, BodyDef.BodyType.StaticBody, signalFixureBL);
        this.signalLBottomBody.setUserData("signalC");
        this.signalLBottom.setUserData("signalC");
        this.mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(this.signalLBottom, this.signalLBottomBody, true, false));

        final FixtureDef signalFixureBR = PhysicsFactory.createFixtureDef(0, 0, 0);
        signalFixureBR.isSensor = true;
        this.signalRBottomBody = PhysicsFactory.createBoxBody(this.mPhysicsWorld, signalRBottom, BodyDef.BodyType.StaticBody, signalFixureBR);
        this.signalRBottom.setUserData("signalD");
        this.signalRBottomBody.setUserData("signalD");
        this.mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(this.signalRBottom, this.signalRBottomBody, true, false));
    }

    private void initCar() {
        this.mCar = new Sprite(80, 20, CAR_SIZE, CAR_SIZE, this.mVehiclesTextureRegion, getVertexBufferObjectManager());
        final FixtureDef carFixtureDef = PhysicsFactory.createFixtureDef(0, 0,0);
        this.mCarBody = PhysicsFactory.createBoxBody(this.mPhysicsWorld, this.mCar, BodyDef.BodyType.DynamicBody, carFixtureDef);
        this.mCarBody.setUserData("car");
        this.mCar.setUserData("car");
        this.mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(this.mCar, this.mCarBody, true, false));
        this.scene.attachChild(this.mCar);
        this.mCamera.setChaseEntity(this.mCar);
    }

    public void intitBorders() {

        final IAreaShape bottomOuter = new Rectangle(0, CAMERA_HEIGHT - 2, CAMERA_WIDTH, 2, getVertexBufferObjectManager());
        final IAreaShape topOuter = new Rectangle(0, 0, CAMERA_WIDTH, 2, getVertexBufferObjectManager());
        final IAreaShape leftOuter = new Rectangle(0, 0, 2, CAMERA_HEIGHT, getVertexBufferObjectManager());
        final IAreaShape rightOuter = new Rectangle(CAMERA_WIDTH - 2, 0, 2, CAMERA_HEIGHT, getVertexBufferObjectManager());

        final IAreaShape bottomInner = new Rectangle(RACETRACK_WIDTH, CAMERA_HEIGHT - 2 - RACETRACK_WIDTH, CAMERA_WIDTH - 2 * RACETRACK_WIDTH, 2, getVertexBufferObjectManager());
        final IAreaShape topInner = new Rectangle(RACETRACK_WIDTH, RACETRACK_WIDTH, CAMERA_WIDTH - 2 * RACETRACK_WIDTH, 2, getVertexBufferObjectManager());
        final IAreaShape leftInner = new Rectangle(RACETRACK_WIDTH, RACETRACK_WIDTH, 2, CAMERA_HEIGHT - 2 * RACETRACK_WIDTH, getVertexBufferObjectManager());
        final IAreaShape rightInner = new Rectangle(CAMERA_WIDTH - 2 - RACETRACK_WIDTH, RACETRACK_WIDTH, 2, CAMERA_HEIGHT - 2 * RACETRACK_WIDTH, getVertexBufferObjectManager());

        final FixtureDef wallFixtureDef = PhysicsFactory.createFixtureDef(0, 0.5f, 0.5f);
        PhysicsFactory.createBoxBody(this.mPhysicsWorld, bottomOuter, BodyDef.BodyType.StaticBody, wallFixtureDef);
        PhysicsFactory.createBoxBody(this.mPhysicsWorld, topOuter, BodyDef.BodyType.StaticBody, wallFixtureDef);
        PhysicsFactory.createBoxBody(this.mPhysicsWorld, leftOuter, BodyDef.BodyType.StaticBody, wallFixtureDef);
        PhysicsFactory.createBoxBody(this.mPhysicsWorld, rightOuter, BodyDef.BodyType.StaticBody, wallFixtureDef);

        PhysicsFactory.createBoxBody(this.mPhysicsWorld, bottomInner, BodyDef.BodyType.StaticBody, wallFixtureDef);
        PhysicsFactory.createBoxBody(this.mPhysicsWorld, topInner, BodyDef.BodyType.StaticBody, wallFixtureDef);
        PhysicsFactory.createBoxBody(this.mPhysicsWorld, leftInner, BodyDef.BodyType.StaticBody, wallFixtureDef);
        PhysicsFactory.createBoxBody(this.mPhysicsWorld, rightInner, BodyDef.BodyType.StaticBody, wallFixtureDef);

        this.scene.attachChild(bottomOuter);
        this.scene.attachChild(topOuter);
        this.scene.attachChild(leftOuter);
        this.scene.attachChild(rightOuter);

        this.scene.attachChild(bottomInner);
        this.scene.attachChild(topInner);
        this.scene.attachChild(leftInner);
        this.scene.attachChild(rightInner);
    }

    public void initTracks() {

        // 2 - Add the tracks
        final ITextureRegion racetrackHorizontalStraightTextureRegion = this.mRacetrackStraightTextureRegion.deepCopy();
        racetrackHorizontalStraightTextureRegion.setTextureWidth(13 * this.mRacetrackStraightTextureRegion.getWidth());

        final ITextureRegion racetrackVerticalStraightTextureRegion = this.mRacetrackStraightTextureRegion;

        /* Top Straight */
        this.scene.attachChild(new Sprite(RACETRACK_WIDTH, 0, 13 * RACETRACK_WIDTH, RACETRACK_WIDTH, racetrackHorizontalStraightTextureRegion, getVertexBufferObjectManager()));

        /* Bottom Straight */
        this.scene.attachChild(new Sprite(RACETRACK_WIDTH, CAMERA_HEIGHT - RACETRACK_WIDTH, 13 * RACETRACK_WIDTH, RACETRACK_WIDTH, racetrackHorizontalStraightTextureRegion, getVertexBufferObjectManager()));


        /* Left Straight */
        final Sprite leftVerticalStraight = new Sprite(0, RACETRACK_WIDTH, RACETRACK_WIDTH, RACETRACK_WIDTH, racetrackVerticalStraightTextureRegion, getVertexBufferObjectManager());
        leftVerticalStraight.setRotation(90);
        leftVerticalStraight.setWidth(7 * RACETRACK_WIDTH);
        this.scene.attachChild(leftVerticalStraight);

        /* Right Straight */
        final Sprite rightVerticalStraight = new Sprite(CAMERA_WIDTH - RACETRACK_WIDTH, RACETRACK_WIDTH, RACETRACK_WIDTH, RACETRACK_WIDTH, racetrackVerticalStraightTextureRegion, getVertexBufferObjectManager());
        rightVerticalStraight.setRotation(90);
        rightVerticalStraight.setWidth(7 * RACETRACK_WIDTH);
        this.scene.attachChild(rightVerticalStraight);

        final ITextureRegion racetrackCurveTextureRegion = this.mRacetrackCurveTextureRegion;

        /* Upper Left */
        this.signalLTop = new Sprite(0, 0, RACETRACK_WIDTH, RACETRACK_WIDTH, mStopSignalTextureRegion, getVertexBufferObjectManager());
        signalLTop.setRotation(90);
        this.scene.attachChild(signalLTop);

         /* Upper Right */
        this.signalRTop = new Sprite(CAMERA_WIDTH - RACETRACK_WIDTH, 0, RACETRACK_WIDTH, RACETRACK_WIDTH, mStopSignalTextureRegion, getVertexBufferObjectManager());
        this.scene.attachChild(signalRTop);

        /* Lower Right */
        this.signalRBottom = new Sprite(CAMERA_WIDTH - RACETRACK_WIDTH, CAMERA_HEIGHT - RACETRACK_WIDTH, RACETRACK_WIDTH, RACETRACK_WIDTH, mStopSignalTextureRegion, getVertexBufferObjectManager());
        signalRBottom.setRotation(270);
        this.scene.attachChild(signalRBottom);

        /* Lower Left */
        this.signalLBottom = new Sprite(0, CAMERA_HEIGHT - RACETRACK_WIDTH, RACETRACK_WIDTH, RACETRACK_WIDTH, mStopSignalTextureRegion, getVertexBufferObjectManager());
        this.scene.attachChild(signalLBottom);
        final Sprite scoreBoard = new Sprite(CAMERA_WIDTH / 2, CAMERA_HEIGHT / 2 - 10, 50, 20, mCenterBoardTextureRegion, getVertexBufferObjectManager());
        this.scene.attachChild(scoreBoard);
    }

    @Override
    public EngineOptions onCreateEngineOptions() {
        this.mCamera = new ZoomCamera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
        this.mCamera.setZoomFactor(2.5f);
        EngineOptions engineOptions = new EngineOptions(true, ScreenOrientation.LANDSCAPE_FIXED, new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), this.mCamera);
        engineOptions.getAudioOptions().setNeedsMusic(true);
        engineOptions.getAudioOptions().setNeedsSound(true);
        return engineOptions;
    }

    @Override
    public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem, float pMenuItemLocalX, float pMenuItemLocalY) {
        return false;
    }
}