import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Files {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(reader.readLine());
        String[] fileTokens=null;

        List<File> files=new ArrayList<>();
        List <String> rootAndName=new ArrayList<>();

        for (int i = 0; i <n ; i++) {

            fileTokens=reader.readLine().split("\\\\|;");
            if (rootAndName.indexOf(fileTokens[0].concat(fileTokens[fileTokens.length-2]))>-1){
                int index=rootAndName.indexOf(fileTokens[0].concat(fileTokens[fileTokens.length-2]));
                String word=fileTokens[0].concat(fileTokens[fileTokens.length-2]);
                files.remove(rootAndName.indexOf(word));
                rootAndName.remove(index);
            }
            rootAndName.add(fileTokens[0].concat(fileTokens[fileTokens.length-2]));
            File file=new File();
            file.root=fileTokens[0];
            file.fileName=fileTokens[fileTokens.length-2];
            file.size=Long.parseLong(fileTokens[fileTokens.length-1]);
            files.add(file);
        }
        String []queryTokens=reader.readLine().split(" ");
        List<File> filterdFiles=new ArrayList<>();
        for (File file:files
             ) {
            if (file.fileName.contains(queryTokens[0])&&file.root.contains(queryTokens[2])){
                filterdFiles.add(file);
            }
        }
if (filterdFiles.size()==0){
    System.out.println("No");
    return;
}
        filterdFiles.sort((f1,f2)->{
            int result=f2.size.compareTo(f1.size);
            if (result==0){
                result=f1.fileName.compareTo(f2.fileName);
            }
            return result;
        });

        for (File filterdFile : filterdFiles) {
            System.out.println(filterdFile.fileName+" - "+ filterdFile.size+" KB");
        }
    }
}
class File{
public String root;
public String fileName;
public Long size;
}