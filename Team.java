import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import java.util.Collections;

public class Team {
    private ArrayList<Player> pg;
    private ArrayList<Player> sg;
    private ArrayList<Player> sf;
    private ArrayList<Player> pf;
    private ArrayList<Player> c;
    ArrayList<Player>[] team = (ArrayList<Player>[])new ArrayList[5];

    public Team(){
        pg = new ArrayList<Player>();
        sg = new ArrayList<Player>();
        sf = new ArrayList<Player>();
        pf = new ArrayList<Player>();
        c = new ArrayList<Player>();
        team[0] = pg;
        team[1] = sg;
        team[2] = sf;
        team[3] = pf;
        team[4] = c;
    }

    public void sort(ArrayList<Player> pos){
        int n = pos.size();
        for (int i = 1; i<n; i++){
            Player key = pos.get(i);
            int j = i-1;
            while(j>=0 && pos.get(j).getRating() > key.getRating()){
                pos.set(j+1, pos.get(j));
                j = j-1;
            }
            pos.set(j+1, key);
        }
        Collections.reverse(pos);
    }

    public void sortAll(){
        sort(pg);
        sort(sg);
        sort(sf);
        sort(pf);
        sort(c);
    }

    public void add(Player p){
        if(p.getPosition().equals("PG")){
            pg.add(p);
        }else if(p.getPosition().equals("SG")){
            sg.add(p);
        }else if(p.getPosition().equals("SF")){
            sf.add(p);
        }else if(p.getPosition().equals("PF")){
            pf.add(p);
        }else if(p.getPosition().equals("C")){
            c.add(p);
        }
        sortAll();
    }



    public void remove(){
        ArrayList<String> names = new ArrayList<String>();
        for(ArrayList<Player> p : team){
            for(Player pl : p){
                names.add(pl.getName());
            }
        }
        Object[] names1 = names.toArray();
        String removePlayer = (String) JOptionPane.showInputDialog(null, "Choose the player you want to remove", null, JOptionPane.QUESTION_MESSAGE, null, names1, null);
        for(ArrayList<Player> p : team){
            for(Player pl : p){
                if(pl.getName().equals(removePlayer)){
                    p.remove(pl);
                    return;
                }
            }
        }
        sortAll();
    }

    public void edit(){
        ArrayList<String> names = new ArrayList<String>();
        for(ArrayList<Player> p : team){
            for(Player pl : p){
                names.add(pl.getName());
            }
        }
        Object[] names1 = names.toArray();
        String editPlayer = (String) JOptionPane.showInputDialog(null, "Choose the player you want to edit", null, JOptionPane.QUESTION_MESSAGE, null, names1, null);
        for(ArrayList<Player> p : team){
            for(Player pl : p){
                if(pl.getName().equals(editPlayer)){
                    String name = JOptionPane.showInputDialog("Enter the player's name", pl.getName());
                    Integer[] numChoices = new Integer[101];
                    int y = 0;
                    for (int i = 0; i<numChoices.length-1; i++){
                        numChoices[i] = y;
                        y++;
                    }
                    int num = (int) JOptionPane.showInputDialog(null, "Choose the player's number", null, JOptionPane.QUESTION_MESSAGE, null, numChoices, pl.getNumber());
                    String[] posChoices = {"PG", "SG", "SF", "PF", "C"};
                    String pos = (String) JOptionPane.showInputDialog(null, "Choose the player's position", null, JOptionPane.QUESTION_MESSAGE, null, posChoices, pl.getPosition());
                    Integer[] ratChoices = new Integer[100];
                    int z = 99;
                    for (int i = 0; i<ratChoices.length-1; i++){
                        ratChoices[i] = z;
                        z--;
                    }
                    int rating = (int) JOptionPane.showInputDialog(null, "Choose the player's rating", null, JOptionPane.QUESTION_MESSAGE, null, ratChoices, pl.getRating());

                    p.remove(pl);
                    add(new Player(name, num, pos, rating));
                    return;
                }
            }
        }
        sortAll();
    }

    public String depthChart(){
        String chart = "";
        chart += "PG: ";
        for(Player p : pg){
            chart += p.getName() + ", ";
        }
        chart += "\n";
        chart += "SG: ";
        for(Player p : sg){
            chart += p.getName() + ", ";
        }
        chart += "\n";
        chart += "SF: ";
        for(Player p : sf){
            chart += p.getName() + ", ";
        }
        chart += "\n";
        chart += "PF: ";
        for(Player p : pf){
            chart += p.getName() + ", ";
        }
        chart += "\n";
        chart += " C: ";
        for(Player p : c){
            chart += p.getName() + ", ";
        }
        chart += "\n";
        return chart;
    }

    public boolean isEmpty(){
        for (int i = 0; i<team.length; i++){
            if(team[i].size() != 0){
                return false;
            }
        }
        return true;
    }
}
