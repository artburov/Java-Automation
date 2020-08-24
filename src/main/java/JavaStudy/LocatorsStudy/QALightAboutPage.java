package JavaStudy.LocatorsStudy;

public class QALightAboutPage {

    //Header phones
    String phoneOne = "//a[contains(text(),'+38 (063) 78-010-78')]";
    String phoneTwo = "//a[contains(text(),'+38 (097) 78-010-78')]";
    String phoneThree = "//a[contains(text(),'+38 (099) 78-010-78')]";

    //Student cabinet
    String studentCab = "//span[@class='reg-text']";

    //Logo section
    String logoImg = "//div[@class='header-bottom']//div[@class='logo-image']";
    String logoText = "//div[@class='header-bottom']//div[@class='logo-text']";

    //Header menu and input search field
    String aboutUs = "//ul[@class='menu']//a[text() = 'О нас']";
    String courses = "//ul[@class='menu']//a[text() = 'Курсы']";
    String news = "//ul[@class='menu']//a[text() = 'Новости']";
    String knowledge = "//ul[@class='menu']//a[text() = 'База знаний']";
    String faq = "//ul[@class='menu']//a[text() = 'FAQ']";
    String contacts = "//ul[@class='menu']//a[text() = 'Контакты']";
    String searchField = "//input[@id='search']";

    //Section title
    String sectionTitle = "//p[@class='heading2' and //p[text()='О нас']]";

    //Header breadcrumbs
    String headerBreadcrumbs = "//div[@class='dimox_breadcrumbs']";

    //Left sidebar
    String qaLight = "//div[@class='sidebar' and //a[text()='QALight — это…']]";
    String administration = "//div[@class='sidebar' and //a[text()='Администрация']]";
    String ourTrainers = "//div[@class='sidebar' and //a[text()='Наши тренеры']]";
    String gallery = "//div[@class='sidebar' and //a[text()='Галерея']]";
    String reviews = "//div[@class='sidebar' and //a[text()='Отзывы']]";

    //Text section
    String textTitle = "//p[contains(text(),'QALight -')]";
    String textImage = "//img[@src='https://qalight.com.ua/wp-content/uploads/2018/11/ISTQB-e1542732588489.png']";

    //Footer section
    String logoImgFooter = "//div[@class='nine']//div[@class='logo-image']";
    String logoTextFooter = "//div[@class='nine']//div[@class='logo-text']";
    String developerLogo = "//p[@class='developer']";

}
