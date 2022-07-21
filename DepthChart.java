import javax.swing.JOptionPane;

public class DepthChart {

    public void run(){
        Team team = new Team();
        int x = 0;
        while(x == 0){
            int input;
            if(team.isEmpty()){
                Object[] options = {"Add Player", "Cancel"};
                input = JOptionPane.showOptionDialog(null, null, null, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
                if(input == 1){
                    input = 3;
                }
            }
            else{
                Object[] options = {"Add Player", "Remove Player", "Edit", "Cancel"};
                input = JOptionPane.showOptionDialog(null, team.depthChart(), null, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
            }
            if(input==0){
                String name = JOptionPane.showInputDialog("Enter the player's name");
                while(name.equals("")){
                    name = JOptionPane.showInputDialog("Enter the player's name");
                }

                Integer[] numChoices = new Integer[101];
                int y = 0;
                for (int i = 0; i<numChoices.length-1; i++){
                    numChoices[i] = y;
                    y++;
                }
                int num = (int) JOptionPane.showInputDialog(null, "Choose the player's number", null, JOptionPane.QUESTION_MESSAGE, null, numChoices, 0);


                String[] posChoices = {"PG", "SG", "SF", "PF", "C"};
                String pos = (String) JOptionPane.showInputDialog(null, "Choose the player's position", null, JOptionPane.QUESTION_MESSAGE, null, posChoices, "PG");

                Integer[] ratChoices = new Integer[100];
                int z = 99;
                for (int i = 0; i<ratChoices.length-1; i++){
                    ratChoices[i] = z;
                    z--;
                }
                int rating = (int) JOptionPane.showInputDialog(null, "Choose the player's rating", null, JOptionPane.QUESTION_MESSAGE, null, ratChoices, 99);

                team.add(new Player(name, num, pos, rating));
            }
            if(input==1){
                team.remove();
            }
            if (input==2){
                team.edit();
            }
            if(input==3){
                return;
            }
        }
    }

    public static void main(String[] args){
        DepthChart x = new DepthChart();
        x.run();
    }
}
