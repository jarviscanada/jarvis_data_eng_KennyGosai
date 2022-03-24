package ca.jrvs.apps.grep;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class JavaGrepImp implements JavaGrep{
    final Logger logger = LoggerFactory.getLogger(JavaGrep.class);

    private String regex;
    private String rootPath;
    private String outFile;

    @Override
    public void process() throws IOException {

        List<String> matchedLines = new ArrayList<String>();
        List<File> listOfFiles = listFiles(rootPath);
        if(listOfFiles == null) return;

        for(File file: listOfFiles){
            List<String> fileMatches = readLines(file);
            matchedLines.addAll(fileMatches);
        }
        try {
            writeToFile(matchedLines);
        } catch (IOException e) {
            throw new IOException();
        }

    }

    @Override
    public List<File> listFiles(String rootdir) {

        File root = new File(rootdir);

        File[] files = root.listFiles();

        List<File> listOfFiles =  new ArrayList<File>();

        if (files == null) return null;

        for( File file : files ) {
            if(file.isFile()){
                listOfFiles.add(file);
            } else {
                listOfFiles.addAll(listFiles(""+file));
            }
        }


        return listOfFiles;
    }

    @Override
    public List<String> readLines(File inputFile) {
        Scanner scanner = null;
        List<String> matchedLines = new ArrayList<String>();
        try {
            scanner = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            if(containsPattern(line)){
                matchedLines.add(inputFile+": "+line);
            }
        }
        return matchedLines;
    }

    @Override
    public boolean containsPattern(String line) {
        if(Pattern.matches(regex, line)) return true;

        return false;
    }

    @Override
    public void writeToFile(List<String> lines) throws IOException {
        try {
            File createFile = new File(outFile);
            createFile.createNewFile();
            FileWriter writeFile = new FileWriter(outFile);
            for(String line: lines){
                writeFile.write(line +"\n");
            }
            writeFile.close();
        } catch (IOException e){
            throw new IOException();
        }
    }

    @Override
    public String getRegex() {
        return regex;
    }

    @Override
    public void setRegex(String regex) {
        this.regex = regex;
    }

    @Override
    public String getRootPath() {
        return rootPath;
    }

    @Override
    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }

    @Override
    public String getOutFile() {
        return outFile;
    }

    @Override
    public void setOutFile(String outFile) {
        this.outFile = outFile;
    }

    public static void main(String[] args) {
        if(args.length != 3){
            throw new IllegalArgumentException("USAGE: JavaGrep regex rootpath outFile");
        }

        BasicConfigurator.configure();

        JavaGrepImp javaGrepImp = new JavaGrepImp();
        javaGrepImp.setRegex(args[0]);
        javaGrepImp.setRootPath(args[1]);
        javaGrepImp.setOutFile(args[2]);

        try {
            javaGrepImp.process();
        } catch (Exception ex) {
            javaGrepImp.logger.error("Error: Unable to process.", ex);
        }
    }
}