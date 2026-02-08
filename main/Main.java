

import model.DataService;
import view.StudentListView;
import controller.AssessmentController;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
     
            DataService model = new DataService();
            
            StudentListView mainView = new StudentListView();
           
            new AssessmentController(model, mainView);

            mainView.setVisible(true);
        });
    }
}