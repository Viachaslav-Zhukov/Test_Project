import Page_Object.ElementsOfTheMainMailPage;
import Page_Object.PersonalMailPageElements;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

// создать класс запуска теста для авторизации пользователя в своей почте и написать письмо
public class CheckingUserAuthorizationWritingALetterTest {
    //пишем тест
    @Test
    public void checkingUserAuthorization_SendingTheEmail() throws InterruptedException {
        // Настройка WebDriverManager для Chrome
        WebDriverManager.chromedriver().setup();
        // Настройка Selenide для использования ChromeDriver
        Configuration.browser = "chrome";
        //создал объект класса главной страницы почты mail.ru
        //открыть страницу почты mail.ru
        ElementsOfTheMainMailPage userAuthorization = open(ElementsOfTheMainMailPage.URL, ElementsOfTheMainMailPage.class);
        //присваиваем значения, для переменных авторизации пользователя
        final String username = "slava.slava.zhukov";
        final String password = "cbkmdfcbkmdf19";
        //вызвали метод авторизации
        userAuthorization.login(username, password);
        //создал объект класса личной страницы авторизированного пользователя почты mail.ru
        PersonalMailPageElements theUserwriteALetter = open(PersonalMailPageElements.URL, PersonalMailPageElements.class);
        //вызываем метод написания и отправки письма
        theUserwriteALetter.writeSendEmail();
    }
}

