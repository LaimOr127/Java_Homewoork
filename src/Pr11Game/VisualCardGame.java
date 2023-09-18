package Pr11Game;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class VisualCardGame extends Application {
    private Stage primaryStage;
    private int numPlayers;
    private int numCards;
    private int currentPlayer;
    private int round;
    private int[] playerDecks;
    private Label resultLabel;
    private TextField cardInput;
    private Button submitButton;
    private Label roundLabel;
    private Button restartButton;
    private Button newGameButton;
    private Button quitButton;
    private GridPane playerDecksPane;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Карточная игра");

        BorderPane root = new BorderPane();

        // Создаем верхнюю панель с выбором количества игроков
        HBox topPanel = new HBox(10);
        topPanel.setPadding(new Insets(20, 20, 20, 20));
        Label playersLabel = new Label("Количество игроков:");
        topPanel.getChildren().add(playersLabel);

        for (int i = 2; i <= 4; i++) {
            Button playerButton = new Button(i + " игрока");
            int num = i;
            playerButton.setOnAction(e -> startGame(num));
            topPanel.getChildren().add(playerButton);
        }

        root.setTop(topPanel);

        resultLabel = new Label();
        resultLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        BorderPane.setAlignment(resultLabel, javafx.geometry.Pos.CENTER);
        root.setCenter(resultLabel);

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void startGame(int numPlayers) {
        this.numPlayers = numPlayers;
        this.numCards = 10;
        this.currentPlayer = 0;
        this.round = 1;
        this.playerDecks = new int[numPlayers];
        resultLabel.setText("");

        GridPane gameGrid = new GridPane();
        gameGrid.setHgap(10);
        gameGrid.setVgap(10);
        gameGrid.setPadding(new Insets(20, 20, 20, 20));

        roundLabel = new Label("Раунд " + round);
        roundLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        GridPane.setColumnSpan(roundLabel, 2);
        gameGrid.add(roundLabel, 0, 0);

        Label playerLabel = new Label("Игрок " + (currentPlayer + 1) + ", введите карту (0-9):");
        gameGrid.add(playerLabel, 0, 1);

        cardInput = new TextField();
        cardInput.setPromptText("Введите карту");
        gameGrid.add(cardInput, 1, 1);

        submitButton = new Button("Ввести");
        submitButton.setOnAction(e -> playRound());
        gameGrid.add(submitButton, 2, 1);

        BorderPane.setAlignment(gameGrid, javafx.geometry.Pos.CENTER);
        BorderPane.setMargin(gameGrid, new Insets(50, 0, 0, 0));
        BorderPane.setAlignment(resultLabel, javafx.geometry.Pos.CENTER);
        BorderPane.setMargin(resultLabel, new Insets(20, 0, 0, 0));

        BorderPane root = (BorderPane) primaryStage.getScene().getRoot();
        root.setCenter(gameGrid);

        restartButton = new Button("Начать заново");
        restartButton.setOnAction(e -> start(primaryStage));
        newGameButton = new Button("Новая игра");
        newGameButton.setOnAction(e -> start(primaryStage));
        quitButton = new Button("Завершить игру");
        quitButton.setOnAction(e -> System.exit(0));

        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(javafx.geometry.Pos.CENTER);
        buttonBox.getChildren().addAll(restartButton, newGameButton, quitButton);
        root.setBottom(buttonBox);

        // Отображение колод игроков
        playerDecksPane = new GridPane();
        playerDecksPane.setHgap(10);
        playerDecksPane.setVgap(10);
        playerDecksPane.setPadding(new Insets(20, 0, 0, 20));
        for (int i = 0; i < numPlayers; i++) {
            Label playerDeckLabel = new Label("Игрок " + (i + 1) + " колода:");
            playerDecksPane.add(playerDeckLabel, 0, i);

            Label playerDeckCountLabel = new Label("Карт: " + numCards);
            playerDecksPane.add(playerDeckCountLabel, 1, i);
        }

        root.setLeft(playerDecksPane);
    }

    private void playRound() {
        try {
            int card = Integer.parseInt(cardInput.getText());
            if (card < 0 || card > 9) {
                showAlert("Ошибка", "Некорректная карта", "Введите число от 0 до 9.");
                return;
            }

            playerDecks[currentPlayer] = card;
            currentPlayer = (currentPlayer + 1) % numPlayers;

            if (currentPlayer == 0) {
                round++;

                // Определение победителя текущего раунда
                int winningPlayer = 0;
                int highestCard = -1;
                for (int i = 0; i < numPlayers; i++) {
                    if (playerDecks[i] > highestCard) {
                        highestCard = playerDecks[i];
                        winningPlayer = i;
                    }
                }

                // Перемещение карт в колоду выигравшего игрока
                for (int i = 0; i < numPlayers; i++) {
                    if (i != winningPlayer) {
                        playerDecks[winningPlayer]++;
                    }
                }

                roundLabel.setText("Раунд " + round);
                resultLabel.setText("Выиграл игрок " + (winningPlayer + 1) + " с картой " + highestCard);

                // Проверка завершения игры
                boolean gameFinished = false;
                for (int i = 0; i < numPlayers; i++) {
                    if (playerDecks[i] == numCards) {
                        showAlert("Поздравляем!", "Игра завершена", "Победил игрок " + (i + 1) + "!");
                        gameFinished = true;
                        break;
                    }
                }

                if (gameFinished) {
                    return;
                }
            }

            playerLabel.setText("Игрок " + (currentPlayer + 1) + ", введите карту (0-9):");
            cardInput.clear();
        } catch (NumberFormatException e) {
            showAlert("Ошибка", "Некорректный ввод", "Введите число от 0 до 9.");
        }
    }

    private void showAlert(String title, String header, String content) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
