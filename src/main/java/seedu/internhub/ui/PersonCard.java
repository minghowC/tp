package seedu.internhub.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.internhub.model.person.Person;

/**
 * An UI component that displays information of a {@code Person}.
 */
public class PersonCard extends UiPart<Region> {

    private static final String FXML = "PersonListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Person person;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label tags;
    @FXML
    private Label jobDescription;
    @FXML
    private Label interviewDate;

    /**
     * Creates a {@code PersonCode} with the given {@code Person} and index to display.
     */
    public PersonCard(Person person, int displayedIndex) {
        super(FXML);
        this.person = person;
        id.setText(displayedIndex + ". ");
        name.setText(person.getCompanyName().fullName);
        jobDescription.setText(person.getJobDescription().value);
        if ((person.getInterviewDate().toString()).equals("")) {
            interviewDate.setText("Interview Date: -");
        } else {
            interviewDate.setText("Interview Date: " + person.getInterviewDate().toString());
        }
        // Tag : use switch case based on the tag name
        switch (person.getTag().getTagShort()) {
        case "NR":
            tags.setStyle(tags.getStyle() + "-fx-background-color: #fdffba"); //yellow
            break;
        case "OA":
            tags.setStyle(tags.getStyle() + "-fx-background-color: #dfbaff"); //purple
            break;
        case "I":
            tags.setStyle(tags.getStyle() + "-fx-background-color: #badaff"); //blue
            break;
        case "R":
            tags.setStyle(tags.getStyle() + "-fx-background-color: #ffbdba"); //red
            break;
        case "O":
            tags.setStyle(tags.getStyle() + "-fx-background-color: #baffdf"); //green
            break;
        default:
            tags.setStyle(tags.getStyle());
            break;
        }
        tags.setText(person.getTag().getTagName());
    }
}
