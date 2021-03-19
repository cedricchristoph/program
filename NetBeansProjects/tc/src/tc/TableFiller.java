package tc;
import java.util.Random;
public class TableFiller extends TableConstructor{
    String[] nameList = {"James", "John", "Robert", "Michael", "William",
                         "David", "Richard", "Joseph", "Thomas", "Charles",
                         "Danni", "Daniel", "Matthew", "Anthony", "Patricia",
                         "Jennifer", "Linda", "Barbara", "Susan", "Jessica",
                         "Sarah", "Karen", "Nancy", "Lisa", "Margaret", "Betty"};
    String[] surnameList = {"Smith", "Johnson", "Brown", "Jones", "Miller", "Davis",
                            "Garcia", "Rodriguez", "Wilson", "Anderson", "Taylor",
                            "Moore", "Thompson", "Lee", "Gonzalez", "Harris", "Clark",
                            "Lewis", "Robinson", "Allen", "Young", "Scott", "Adams",
                            "Baker", "Nelson", "Hill", "Carter", "Torres", "Turner", "Collins"};

    String[] carManufactorList;
    String[] colors;

    public TableFiller(){

    }

    public void printTableWithData(String dataType, int rowAmount){
        switch (dataType){
            case "persons":
                printHeader("ID", "NAME", "SURNAME", "TELEPHONE NUMBER");
                for (int i=0; i<rowAmount; i++){
                    printRow(rowContent(dataType, 4, i));
                }
                break;
        }
    }

    public String[] rowContent(String dataType, int colAmount, int j){
        String[] rowContent = new String[colAmount];
        rowContent[0] = "" + j;
        switch (dataType){
            case "persons":
                for (int i=1; i<colAmount; i++){
                    switch (i){
                        case 1:
                            rowContent[i] = nameList[randomIndex(nameList.length)];
                            break;
                        case 2:
                            rowContent[i] = surnameList[randomIndex(nameList.length)];
                            break;
                        case 3:
                            rowContent[i] = "" + (int) randomTlf() + " " + (int) randomTlf() + " " + (int) randomTlf();
                            break;
                    }
                }
                break;
        }
        return rowContent;
    }

    public double randomTlf(){
        double val = Math.floor(Math.random() * 990);
        val += Math.floor((val+110)/110);
        return (000 + val);
    }

    public int randomIndex(int to){
        Random random = new Random();
        int numb = random.nextInt(to);
        return numb;
    }
}
