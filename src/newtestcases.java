import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class newtestcases {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PRATHAMESH\\Downloads\\chromedriver-win64\\chromedriver.exe");
        WebDriver wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
        wd.get("http://localhost/Doctor-Appointment-System/");
        System.out.println(wd.getCurrentUrl());

        // 1st test
        String expTitle = "http://localhost/Doctor-Appointment-System/";
        String actTitle = wd.getCurrentUrl();
        if (expTitle.equals(actTitle)) {
            System.out.println("Test 1: Pass");
        } else {
            System.out.println("Test 1: Fail");
        }

        // 2nd test
        WebElement loginLink = wd.findElement(By.xpath("/html/body/div[2]/div/p[2]/a"));
        loginLink.click();
        wd.findElement(By.name("doctorId")).sendKeys("123");
        wd.findElement(By.name("password")).sendKeys("1234");
        wd.findElement(By.xpath("/html/body/div[1]/div/div[3]/form/button")).click();
        try {
            wd.switchTo().alert().accept();
            System.out.println("Test 2: Pass");
        } catch (Exception e) {
            System.out.println("Test 2: Fail");
        }

        // 3rd test
//        wd.findElement(By.name("doctorId")).clear();
//        wd.findElement(By.name("password")).clear();
        wd.findElement(By.name("doctorId")).sendKeys("123");
        wd.findElement(By.name("password")).sendKeys("123");
        wd.findElement(By.xpath("/html/body/div[1]/div/div[3]/form/button")).click();
        System.out.println("Test 3: Pass");

        // 4th test
        wd.findElement(By.xpath("//*[@id=\"wrapper\"]/nav/div[2]/ul/li[2]/a")).click();
        wd.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div/div/div/form/div[6]/div/button")).click();
        System.out.println("Test 4: Pass");

        // 5th test
        DateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
        String date1 = formatter1.format(new Date());
        wd.findElement(By.name("date")).sendKeys(date1);

        SimpleDateFormat simpleformat = new SimpleDateFormat("dd/MMMM/yyyy hh:mm:s");
        Format f = new SimpleDateFormat("HH.mm.ss Z");
        f = new SimpleDateFormat("EEEE");
        String str = f.format(new Date());
        wd.findElement(By.name("scheduleday")).sendKeys(str);

        wd.findElement(By.xpath("//*[@id=\"starttime\"]")).click();
        Calendar now = Calendar.getInstance();
        String currentTime = now.get(Calendar.HOUR_OF_DAY) + ":" + now.get(Calendar.MINUTE);
        now.add(Calendar.MINUTE, 20);
        String updateTime = now.get(Calendar.HOUR_OF_DAY) + ":" + now.get(Calendar.MINUTE);
        wd.findElement(By.name("starttime")).sendKeys(currentTime);
        wd.findElement(By.name("endtime")).sendKeys(updateTime);
        wd.findElement(By.name("bookavail")).sendKeys("available");
        wd.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div/div/div/form/div[6]/div/button")).click();

        try {
            wd.switchTo().alert().accept();
            System.out.println("Test 5: Pass");
        } catch (Exception e) {
            System.out.println("Test 5: Fail");
        }

        // 6th test
        wd.findElement(By.xpath("/html/body/div[1]/nav/div[2]/ul/li[3]/a")).click();
        wd.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/table/tbody[2]/tr/td[9]/a/span")).click();
        try {
            wd.switchTo().alert().accept();
            System.out.println("Test 6: Pass");
        } catch (Exception e) {
            System.out.println("Test 6: Fail");
        }

        // 7th test
        wd.findElement(By.xpath("/html/body/div[1]/nav/ul/li/a")).click();
        wd.findElement(By.xpath("/html/body/div[1]/nav/ul/li/ul/li[5]/a")).click();
        System.out.println("Test 7: Pass");

        // 8th test
        wd.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a/b")).click();
        wd.findElement(By.name("icPatient")).sendKeys("125");
        wd.findElement(By.name("password")).sendKeys("pass");
        wd.findElement(By.xpath("//*[@id=\"login\"]")).click();
        try {
            wd.switchTo().alert().accept();
            System.out.println("Test 8: Pass");
        } catch (Exception e) {
            System.out.println("Test 8: Fail");
        }

        // 9th test
        wd.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a/b")).click();
        wd.findElement(By.name("icPatient")).clear();
        wd.findElement(By.name("password")).clear();
        wd.findElement(By.name("icPatient")).sendKeys("145236");
        wd.findElement(By.name("password")).sendKeys("pass@123");
        wd.findElement(By.xpath("//*[@id=\"login\"]")).click();
        System.out.println("Test 9: Pass");

        // 10th test
        wd.findElement(By.xpath("/html/body/nav/div/div[2]/ul[2]/li/a")).click();
        wd.findElement(By.xpath("/html/body/nav/div/div[2]/ul[2]/li/ul/li[1]/a")).click();
        wd.findElement(By.xpath("/html/body/div[1]/section/div/div[1]/div[1]/div/div/button")).click();
        wd.findElement(By.xpath("/html/body/div[1]/section/div/div[2]/div/div/div/div[2]/form/table/tbody/tr[4]/td[2]/div[1]/label")).click();
        wd.findElement(By.name("patientPhone")).sendKeys("8805297911");
        wd.findElement(By.name("patientAddress")).sendKeys("Shivajinagar,Pune");
        wd.findElement(By.xpath("/html/body/div[1]/section/div/div[2]/div/div/div/div[2]/form/table/tbody/tr[10]/td/input")).click();
        System.out.println("Test 10: Pass");

        // 11th test
        wd.findElement(By.xpath("/html/body/nav/div/div[2]/ul[2]/li/a")).click();
        wd.findElement(By.xpath("/html/body/nav/div/div[2]/ul[2]/li/ul/li[4]/a")).click();
		System.out.println("pass");
		}
}