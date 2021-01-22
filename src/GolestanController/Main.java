

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**   CREATED BY FATEME SOLEYMANIAN AND HOSSEIN MIRZAPUR */

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("GolestanView/FirstPage.fxml"));
        primaryStage.setTitle("Golestan System");
        primaryStage.setScene(new Scene(root, 600, 680));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
/*                               ****** All Tables ******
1. BreakTable(reasonOfBreak,breakTime)
2. DeletedStd(stdName,stdNum,deleteTime,deleteReason)
3. DeleteTable(deleteReason,year,stdId)
4. DocsTable(docType,docNum)
5. EmpTable(empName,empNum,address,nationalCode,fatherName,birthDate,phoneNumber,email,military,education,religion,nativeLand,maritialStatus)
6. FirstPageTable(username,password)
7. FullReportTable(stdNum,stdName,gender,fatherName,nationalId,birthDate,entryTerm,average,passedUnits)
8. HalfReportTable(stdNum,stdName,gender,fatherName,nationalId,birthDate,entryTerm)
9. LoanTable(loanAmount,personToGuarantee,loanNumber)
10. ScoreRegisterTable(stdName,stdNum,subjectCode,score)
11. BankTable(paymentAmount,cardNumber,cardSecondPass,cvv2,expireDay,expireYear )
12. ArtTable(unitName,unitCode,unitNum)
13. EngineeringTable(unitName,unitCode,unitNum)
14. HumanitiesTable(unitName,unitCode,unitNum)
15. UnitResult(stdNum,unitCode)
16. EmpLastState(empNum,empState)
17. PaymentTable(paymentId,paymentTerm,bankName,paymentAmount,payStdNum)

*/
