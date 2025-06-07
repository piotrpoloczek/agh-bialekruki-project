package pl.edu.agh.mwo.report.project;


import java.io.IOException;
import java.nio.file.Path;


public class Main {
    public static void main(String[] args) throws IOException {
      
      
//         System.out.println(
//                 ExcelParser.parseExcelToProjectList(
//                         Path.of("/home/students/m/d/mdebski/IdeaProjects/agh-bialekruki-project/"
//                                 + "src/main/resources/input/reporter-dane/2012/01")
//                 ));
        System.out.println("Welcome to Bialekruki project!");

        InputManager inputManager = new InputManager(args);
    }
}
