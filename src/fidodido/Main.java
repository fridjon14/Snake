package fidodido;

import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.*;

import java.util.ArrayList;
import java.util.List;


public class Main extends Application {

    static final int height = 600;
    static final int width = 600;
    static List<Snake> snakur = new ArrayList<>();
    private VBox root = new VBox();
    private Canvas c = new Canvas(10,10);
    private Snake snake = new Snake(300,300,20,20,"player", Color.WHITE);
    private int speed = 5;
    private double time = 0;
    private boolean noFood = false;
    private int foodX;
    private int foodY;
    private Food food;


    static Random rand = new Random();



    private Parent RenderScreen(){
        root.setPrefSize(width,height);
        root.getChildren().add(snake);
        food = new Food(rand.nextInt(width), foodY = rand.nextInt(height),10, Color.RED);
        root.getChildren().add(food);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now){
                update();
                System.out.println(now);
            }
        };
        timer.start();

        return root;

    }
    private void update(){
        time += 0.01;
    }


    @Override
    public void start(Stage primaryStage) throws Exception{

        Scene s = new Scene(RenderScreen(), width, height, Color.BLACK);
        primaryStage.setScene(s);

        s.setOnKeyPressed(k -> {
            switch (k.getCode()) {
                case UP:
                    snake.velocityY = - speed;
                    snake.velocityX = 0;
                    break;
                case DOWN:
                    snake.velocityY = speed;
                    snake.velocityX = 0;
                    break;
                case LEFT:
                    snake.velocityX = - speed;
                    snake.velocityY = 0;
                    break;
                case RIGHT:
                    snake.velocityX = speed;
                    snake.velocityY = 0;
                    break;
            }
        });
        //GraphicsContext gc = c.getGraphicsContext2D();
        //gc.setFill(Color.BLACK);
        primaryStage.show();
    }
    private static class Food extends Circle {
        boolean consumed = false;

        Food(int x, int y, int r, Color c) {
            super(x, y, r, c);
            setTranslateX(x);
            setTranslateY(y);
        }
        int getFoodX(){
            return (int) getTranslateX();
        }
        int getFoodY(){
            return (int) getTranslateY();
        }


    }

    private static class Snake extends Rectangle {
        double velocityX;
        double velocityY;

        Snake(int x, int y, int w, int h, String type, Color c) {
            super(w,h,c);
            setTranslateX(x);
            setTranslateY(y);
        }
        void moveUp(){
            setTranslateY(getTranslateY() - 5);
        }
        void moveDown(){
            setTranslateY(getTranslateY() + 5);
        }
        void moveLeft(){
            setTranslateX(getTranslateX() - 5);
        }
        void moveRight(){
            setTranslateX(getTranslateX() + 5);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}