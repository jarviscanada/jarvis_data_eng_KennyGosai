package ca.jrvs.apps.grep;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JavaGrepLambdaImp extends JavaGrepImp {
    public static void main(String[] args) {
        if(args.length != 3){
            throw new IllegalArgumentException("USAGE: JavaGrep regex rootpath outFile");
        }

        JavaGrepImp javaGrepLambdaImp = new JavaGrepLambdaImp();
        javaGrepLambdaImp.setRegex(args[0]);
        javaGrepLambdaImp.setRootPath(args[1]);
        javaGrepLambdaImp.setOutFile(args[2]);

        try{
            javaGrepLambdaImp.process();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<File> listFiles(String rootdir) {
        List<File> fileList = new ArrayList<File>();
        try {
            Files.walk(Paths.get(rootdir))
                    .filter(Files::isRegularFile)
                    .forEach(s->{
                        fileList.add(new File(s.toString()));
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileList;
    }

    @Override
    public List<String> readLines(File inputFile) {
        List<String> matchedLines = new ArrayList<String>();

        try {
            Files.lines(Paths.get(inputFile.toString()))
                    .forEach(s -> {
                        if(containsPattern(s)){
                            matchedLines.add(inputFile+": "+s);
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return matchedLines;
    }

}