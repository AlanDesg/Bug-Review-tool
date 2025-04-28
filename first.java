import javax.swing.JOptionPane;

public class first {
    public static void main(String[] args) {
        String response;
        System.out.println("hello world welcome");
        System.out.println("JAVA PROG");
       JOptionPane.showMessageDialog(null,"HELLO\nThis is AUTOMATED BUG REVIEW TOOL\nclick on OK to proceed ahead", "AUTOMATED BUG REVIEW TOOL", 2);
       response = JOptionPane.showInputDialog(null, "WANT TO CHECK BUGS\n 1 for YES \n 2 for NO");
       int check = Integer.parseInt(response);
        switch (check){
                         case 1:{
                                System.out.println("hello world welcome");
                                JOptionPane.showMessageDialog(null,"hey lead hello","YOU CHOSE YES", 0);
                             }
                             break;
                        case 2:{
                                 System.out.println("EXIT FROM APP");
                                 JOptionPane.showMessageDialog(null,"THANKS FOR USING THE TOOL","YOU CHOSE TO EXIT", 0);
                                 }
                        default:{
                            JOptionPane.showMessageDialog(null,"Some Error Occured","YOU CHOSE TO EXIT", 0);
                        }
                      }
    }
}