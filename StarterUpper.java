/*
In order to help learn course concepts, I worked on the homework with no one, discussed homework topics and issues
with no one, and/or consulted related material that can be found at Java Documentation, GeeksForGeeks.
*/

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.Priority;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import java.io.File;
import java.util.Collections;
import java.util.Optional;

/**
 * JavaFX Class (extends Application) that creates a GUI which tracks startup ideas.
 * @author Nicholas Polimeni
 * @version 1.0.0
 */
public class StarterUpper extends Application {
    private ObservableList<StartUpIdea> ideas = FXCollections.observableArrayList();

    /**
     * Main method. Manages the creation of the Application.
     * @param args representing command line arguments on launch
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //Stage title
        primaryStage.setTitle("Problem Ideation Form");

        //Layout structure setup------
        //Overarching structure
        ScrollPane root = new ScrollPane();
        StackPane pane = new StackPane();
        VBox main = new VBox();
        VBox header = new VBox();
        VBox topBox = new VBox();
        HBox optionButtons = new HBox();
        VBox prevIdeas = new VBox();
        VBox leftCol = new VBox();
        VBox rightCol = new VBox();
        HBox body = new HBox();
        //Structure within overarching
        HBox problem = new HBox();
        HBox target = new HBox();
        HBox need = new HBox();
        HBox knownCustomers = new HBox();
        HBox marketSize = new HBox();
        HBox existing = new HBox();
        HBox customerD = new HBox();
        HBox productD = new HBox();
        //Layout structure property customization------
        Region problemSpacer = new Region();
        HBox.setHgrow(problemSpacer, Priority.ALWAYS);

        Region targetSpacer = new Region();
        HBox.setHgrow(targetSpacer, Priority.ALWAYS);

        Region needSpacer = new Region();
        HBox.setHgrow(needSpacer, Priority.ALWAYS);

        Region knownCustomersSpacer = new Region();
        HBox.setHgrow(knownCustomersSpacer, Priority.ALWAYS);

        Region marketSizeSpacer = new Region();
        HBox.setHgrow(marketSizeSpacer, Priority.ALWAYS);

        Region existingSpacer = new Region();
        HBox.setHgrow(existingSpacer, Priority.ALWAYS);

        Region customerDSpacer = new Region();
        HBox.setHgrow(customerDSpacer, Priority.ALWAYS);

        Region productDSpacer = new Region();
        HBox.setHgrow(productDSpacer, Priority.ALWAYS);

        //Idea input labels------
        Label problemLabel = new Label("What is the problem? ");
        Label targetLabel = new Label("Who is the target customer? ");
        Label needLabel = new Label("How badly does the customer NEED this problem fixed (1-10)? ");
        Label knownCustomersLabel = new Label("How many people do you know who might experience this problem?");
        Label marketSizeLabel = new Label("How big is the target market? ");
        Label existingLabel = new Label("Who are the competitors/existing solutions? ");
        Label customerDLabel = new Label("How difficult will it be to acquire customers (1-10)? ");
        Label productDLabel = new Label("How difficult will it be to create the product? ");

        //Label settings------
        problemLabel.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        targetLabel.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        needLabel.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        knownCustomersLabel.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        marketSizeLabel.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        existingLabel.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        customerDLabel.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        productDLabel.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));

        //Idea input text fields------
        TextField problemText = new TextField();
        problemText.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 15));

        TextField targetText = new TextField();
        targetText.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 15));

        TextField needText = new TextField();
        needText.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 15));

        TextField knownCustomersText = new TextField();
        knownCustomersText.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 15));

        TextField marketSizeText = new TextField();
        marketSizeText.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 15));

        TextField existingText = new TextField();
        existingText.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 15));

        TextField customerDText = new TextField();
        customerDText.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 15));

        TextField productDText = new TextField();
        productDText.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 15));

        //TextField settings------
        problemText.setPrefWidth(450);
        targetText.setPrefWidth(450);
        needText.setPrefWidth(100);
        knownCustomersText.setPrefWidth(100);
        marketSizeText.setPrefWidth(100);
        existingText.setPrefWidth(550);
        customerDText.setPrefWidth(100);
        productDText.setPrefWidth(200);

        //HBox-row with option buttons------
        Button resetForm = new Button("Reset the Tracker");
        resetForm.setId("reset");
        Button saveToFile = new Button("Save Ideas to File");
        Button sortIdeas = new Button("Sort Idea List by Potential");
        Button addIdea = new Button("Add Idea to Tracker");
        //Spacers for the buttons
        resetForm.getStyleClass().add("warning-button");
        Region sortSpacer = new Region();
        HBox.setHgrow(sortSpacer, Priority.ALWAYS);
        Region resetSpacer = new Region();
        HBox.setHgrow(resetSpacer, Priority.ALWAYS);
        Region saveSpacer = new Region();
        HBox.setHgrow(saveSpacer, Priority.ALWAYS);
        Region leftSpacer = new Region();
        HBox.setHgrow(leftSpacer, Priority.ALWAYS);
        Region rightSpacer = new Region();
        HBox.setHgrow(rightSpacer, Priority.ALWAYS);
        //Button visual settings
        addIdea.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 15));
        sortIdeas.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 15));
        resetForm.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 15));
        saveToFile.setFont(Font.font("Verdana", FontWeight.NORMAL, FontPosture.REGULAR, 15));

        //Painting the stage------
        //Header
        Text appHeader = new Text("Startup Idea Tracker");
        appHeader.setFont(Font.font("Helvetica", FontWeight.BOLD, FontPosture.REGULAR, 50));

        Text appSubhead = new Text("Add A New Startup Idea to Be Tracked:");
        appSubhead.setFont(Font.font("Helvetica", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 25));

        //Previous Submitted Ideas
        Text prevIdeasHeader = new Text("Ideas Already Being Tracked:");
        prevIdeasHeader.setFont(Font.font("Helvetica", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 25));

        //Creates rows for the label and text inputs
        problem.getChildren().addAll(problemLabel, problemSpacer, problemText);
        target.getChildren().addAll(targetLabel, targetSpacer, targetText);
        need.getChildren().addAll(needLabel, needSpacer, needText);
        knownCustomers.getChildren().addAll(knownCustomersLabel, knownCustomersSpacer, knownCustomersText);
        marketSize.getChildren().addAll(marketSizeLabel, marketSizeSpacer, marketSizeText);
        existing.getChildren().addAll(existingLabel, existingSpacer, existingText);
        customerD.getChildren().addAll(customerDLabel, customerDSpacer, customerDText);
        productD.getChildren().addAll(productDLabel, productDSpacer, productDText);
        Line headerLine = new Line(0, 0, 600, 0);
        Line[] lines = createLines(7);

        //Adds margin and spacing to the rows and its containers
        VBox.setMargin(topBox, new Insets(30));
        topBox.setSpacing(20);
        VBox.setMargin(prevIdeas, new Insets(30));

        //Creates the option button row
        optionButtons.getChildren().addAll(leftSpacer, resetForm, resetSpacer, saveToFile, saveSpacer, sortIdeas,
                sortSpacer, addIdea, rightSpacer);

        //Adds all previous elements to the overarching structure
        header.getChildren().addAll(appHeader, headerLine);
        topBox.getChildren().addAll(appSubhead, problem, lines[0], target, lines[1], need, lines[2], knownCustomers,
                lines[3], marketSize, lines[4], existing, lines[5], customerD, lines[6], productD);
        prevIdeas.getChildren().add(prevIdeasHeader);

        //Button click handling------
        addIdea.setOnAction(event -> {
                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setTitle("Please Confirm");
                a.setContentText("Are you sure you want this idea added?");
                ButtonType cancel = new ButtonType("Cancel");
                ButtonType proceed = new ButtonType("Sounds good!");
                a.getButtonTypes().setAll(cancel, proceed);
                Optional<ButtonType> answer = a.showAndWait();
                if (answer.get() == proceed && checkInputs(problemText, targetText, needText, knownCustomersText,
                        marketSizeText, existingText, customerDText, productDText)) {
                    String problemStr = problemText.getText().strip();
                    String targetStr = targetText.getText().strip();
                    int needNum = Integer.parseInt(needText.getText().strip());
                    int knownCustomersNum = Integer.parseInt(knownCustomersText.getText().strip());
                    int marketSizeNum = Integer.parseInt(marketSizeText.getText().strip());
                    String existingStr = existingText.getText().strip();
                    int customerDNum = Integer.parseInt(customerDText.getText().strip());
                    String productDStr = productDText.getText().strip();
                    ideas.add(new StartUpIdea(problemStr, targetStr, needNum, knownCustomersNum,
                            marketSizeNum, existingStr, customerDNum, productDStr));
                    problemText.clear();
                    targetText.clear();
                    needText.clear();
                    knownCustomersText.clear();
                    marketSizeText.clear();
                    existingText.clear();
                    customerDText.clear();
                    productDText.clear();
                }
            });

        sortIdeas.setOnAction(event -> {
                Collections.sort(ideas);
            });

        resetForm.setOnAction(event -> {
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setTitle("WARNING");
                a.setContentText("This will ERASE ALL DATA. Proceed?");
                ButtonType cancel = new ButtonType("Cancel");
                ButtonType proceed = new ButtonType("Proceed");
                a.getButtonTypes().setAll(cancel, proceed);
                Optional<ButtonType> answer = a.showAndWait();
                if (answer.get() == proceed) {
                    ideas.clear();
                    problemText.clear();
                    targetText.clear();
                    needText.clear();
                    knownCustomersText.clear();
                    marketSizeText.clear();
                    existingText.clear();
                    customerDText.clear();
                    productDText.clear();
                    File saveFile = new File("StartupIdeas.txt");
                    saveFile.delete();
                }
            });

        EventHandler<ActionEvent> saveToFileEvent = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setTitle("Please Confirm");
                a.setContentText("Are you sure you want these ideas to be saved?");
                ButtonType cancel = new ButtonType("Cancel");
                ButtonType proceed = new ButtonType("Sounds good!");
                a.getButtonTypes().setAll(cancel, proceed);
                Optional<ButtonType> answer = a.showAndWait();
                if (answer.get() == proceed) {
                    File saveFile = new File("StartupIdeas.txt");
                    FileUtil.saveIdeasToFile(ideas, saveFile);
                }
            }
        };
        saveToFile.setOnAction(saveToFileEvent);

        ListView<StartUpIdea> displayIdeas = new ListView<StartUpIdea>(ideas);
        prevIdeas.getChildren().add(displayIdeas);
        //
        header.setAlignment(Pos.CENTER);
        prevIdeas.setAlignment(Pos.CENTER);
        rightCol.setAlignment(Pos.CENTER);
        leftCol.getChildren().addAll(topBox, optionButtons);
        rightCol.getChildren().addAll(prevIdeas);
        body.getChildren().addAll(leftCol, rightCol);
        main.getChildren().addAll(header, body);
        pane.getChildren().add(main);
        root.setContent(pane);
        Scene scene = new Scene(root, 1660, 800);
        scene.getStylesheets().add("style.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Creates lines for the GUI.
     * @param num int representing the number of lines to be created.
     * @return an array of Line objects.
     */
    public Line[] createLines(int num) {
        Line[] lines = new Line[num];
        for (int i = 0; i < num; i++) {
            lines[i] = new Line(0, 0, 1140, 0);
        }
        return lines;
    }

    /**
     * Checks whether the String input is valid (non-empty).
     * @param input String representing the user's text input.
     * @return boolean, true if invalid, false if valid.
     */
    public boolean checkStrInput(String input) {
        if (input.strip().isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * Creates an error Alert object with given messages.
     * @param errorArea String representing the field where the error occurred.
     * @param extraMsg String representing an additional error message.
     */
    public void createAlert(String errorArea, String extraMsg) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Invalid Input");
        a.setContentText(errorArea + " field is empty or invalid. " + extraMsg);
        a.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        a.showAndWait();
    }

    /**
     * Checks whether or not all of the inputs are valid.
     * @param problemText TextField with the user's input for the problem question.
     * @param targetText TextField with the user's input for the target market.
     * @param needText TextField with the user's input for the customer need question.
     * @param knownCustomersText TextField with the user's input for the number of known customers question.
     * @param marketSizeText TextField with the user's input for the market size question.
     * @param existingText TextField with the user's input for the existing solutions question.
     * @param customerDText TextField with the user's input for the customer acquisition difficulty question.
     * @param productDText TextField with the user's input for the product creation difficulty question.
     * @return boolean. True if all input is valid. False if not.
     */
    public boolean checkInputs(TextField problemText, TextField targetText, TextField needText,
                               TextField knownCustomersText, TextField marketSizeText, TextField existingText,
                               TextField customerDText, TextField productDText) {
        boolean flag = true;
        String problemStr = problemText.getText();
        if (checkStrInput(problemStr)) {
            flag = false;
            createAlert("Problem", "Please enter a new answer.");
        }

        String targetStr = targetText.getText();
        if (checkStrInput(problemStr)) {
            flag = false;
            createAlert("Target Market", "Please enter a new answer.");
        }

        int needNum = 0;
        try {
            needNum = Integer.parseInt(needText.getText().strip());
            if (needNum < 1 || needNum > 10) {
                flag = false;
                createAlert("Customer Need", "Please enter a valid number.");
            }
        } catch (NumberFormatException e) {
            flag = false;
            createAlert("Customer Need", "Please enter a valid number.");
        }

        int knownCustomersNum = 0;
        try {
            knownCustomersNum = Integer.parseInt(knownCustomersText.getText().strip());
            if (knownCustomersNum < 0) {
                flag = false;
                createAlert("Known Customers", "Please enter a non-negative number.");
            }
        } catch (NumberFormatException e) {
            flag = false;
            createAlert("Known Customers", "Please enter a valid number.");
        }

        int marketSizeNum = 0;
        try {
            marketSizeNum = Integer.parseInt(marketSizeText.getText().strip());
            if (marketSizeNum < 0) {
                flag = false;
                createAlert("Market Size", "Please enter a non-negative number.");
            }
        } catch (NumberFormatException e) {
            flag = false;
            createAlert("Market Size", "Please enter a valid number.");
        }

        String existingStr = existingText.getText();
        if (checkStrInput(existingStr)) {
            flag = false;
            createAlert("Existing Solutions", "Please enter a new answer.");
        }

        int customerDNum = 0;
        try {
            customerDNum = Integer.parseInt(customerDText.getText().strip());
            if (customerDNum < 1 || customerDNum > 10) {
                flag = false;
                createAlert("Customer Acquisition Difficulty", "Please enter a valid number.");
            }
        } catch (NumberFormatException e) {
            flag = false;
            createAlert("Customer Acquisition Difficulty", "Please enter a valid number.");
        }

        String productDStr = productDText.getText();
        if (checkStrInput(productDStr)) {
            flag = false;
            createAlert("Product Creation Difficulty", "Please enter a new answer.");
        }

        return flag;
    }
}
