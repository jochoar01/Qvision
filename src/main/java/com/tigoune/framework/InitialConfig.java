package com.tigoune.framework;

import java.io.IOException;
import javax.swing.JOptionPane;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InitialConfig {

    WebDriver chromedriver = null;
    InternetExplorerDriver iedriver = null;

    /** Abrir aplicación de escritorio dado el nombre*/
    public void desktopAppByName(String appName) throws IOException {
        Runtime.getRuntime().exec("cmd /C start /wait " + appName);
    }
    /** Abrir aplicación de escritorio dada la ruta */
    public void desktopAppByPath(String path) throws IOException {
        Runtime.getRuntime().exec(path);
    }
    /** Abrir aplicación Web en navegador dado*/
    public void webBroserConfig(String webBroserType, String url) {
        try {
            if (webBroserType.equals("chrome")) {
                String exePath = "src/test/resources/driver/chromedriver.exe";
                System.setProperty("webdriver.chrome.driver", exePath);
                chromedriver = new ChromeDriver();
                chromedriver.get(url);
                chromedriver.manage().window().maximize();

            } else if (webBroserType.equals("explorer")) {
                String exePath = "src/test/resources/driver/IEDriverServer.exe";
                System.setProperty("webdriver.ie.driver", exePath);
                iedriver = new InternetExplorerDriver();
                iedriver.get(url);
                iedriver.manage().window().maximize();

            } else {
                JOptionPane.showMessageDialog(null, "Porfavor ingrese el tipo de navegador 'chrome' o 'explorer'",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(null, "Corrija e intente nuevamente", "", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        } catch (Exception e) {
        }
    }
    /** Cerrar navegador Web dado*/
    public void closeBrowser(String browser) {
        if (browser.equals("explorer")) {
            iedriver.quit();
        } else if (browser.equals("chrome")) {
            chromedriver.quit();
        }
    }
    /** Cerrar aplicación de escritorio */
    public void closeDesktopApp(String appName) throws IOException {
        Runtime.getRuntime().exec("TASKKILL /PID " + appName);
    }
}