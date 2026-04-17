import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class HanoiFX extends Application {

    static class Move {
        int from, to;
        Move(int f, int t) { from = f; to = t; }
    }

    List<Integer>[] rods = new ArrayList[3];
    List<Move> moves = new ArrayList<>();
    int step = 0;

    Timeline timeline;

    double[] rodX = {150, 300, 450};

    @Override
    public void start(Stage stage) {

        int n = 5;

        for (int i = 0; i < 3; i++)
            rods[i] = new ArrayList<>();

        for (int i = n; i >= 1; i--)
            rods[0].add(i);

        hanoi(n, 0, 1, 2, moves);

        Canvas canvas = new Canvas(600, 400);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Button nextBtn = new Button("Next ▶");
        Button playBtn = new Button("Play ▶▶");

        nextBtn.setOnAction(e -> {
            stepOnce(gc);
        });

        timeline = new Timeline(
                new KeyFrame(Duration.millis(700), e -> stepOnce(gc))
        );
        timeline.setCycleCount(moves.size());

        playBtn.setOnAction(e -> timeline.play());

        HBox controls = new HBox(10, nextBtn, playBtn);

        VBox root = new VBox(10, canvas, controls);

        draw(gc);

        stage.setScene(new Scene(root));
        stage.setTitle("Hanoi - Play / Next");
        stage.show();
    }

    void stepOnce(GraphicsContext gc) {
        if (step >= moves.size()) return;

        Move m = moves.get(step++);

        int disk = rods[m.from].remove(rods[m.from].size() - 1);
        rods[m.to].add(disk);

        draw(gc);
    }

    void draw(GraphicsContext gc) {
        gc.clearRect(0, 0, 600, 400);

        // tije
        gc.setFill(Color.BLACK);
        for (int i = 0; i < 3; i++) {
            gc.fillRect(rodX[i], 100, 10, 200);
        }

        // discuri
        for (int r = 0; r < 3; r++) {
            for (int i = 0; i < rods[r].size(); i++) {

                int disk = rods[r].get(i);

                double width = disk * 20;
                double x = rodX[r] - width / 2;
                double y = 300 - i * 20;

                gc.setFill(Color.hsb(disk * 40, 0.8, 0.9));
                gc.fillRect(x, y, width, 18);
                gc.setStroke(Color.BLACK);
                gc.strokeRect(x, y, width, 18);
            }
        }
    }

void hanoi(int n, int from, int aux, int to, List<Move> moves) {
    if (n == 1) {
        moves.add(new Move(from, to));
    } else {
        hanoi(n - 1, from, to, aux, moves);
        moves.add(new Move(from, to));
        hanoi(n - 1, aux, from, to, moves);
    }
}

    public static void main(String[] args) {
        launch();
    }
}
