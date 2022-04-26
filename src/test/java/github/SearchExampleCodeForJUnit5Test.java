package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchExampleCodeForJUnit5Test {

  @Test
  void shouldFindExampleCodeForJUnit5InGithub() {
    // открыть страницу github.com
    open("https://github.com/");
    // ввести в поле поиска selenide и нажать Enter
    $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
    // нажимаем на линк от первого результата поиска
    $("ul.repo-list li").$("a").click();
    // переход в раздел Wiki
    $("#wiki-tab").click();
    // поиск SoftAssertions
    $("#wiki-pages-filter").setValue("SoftAssertions");
    // клик по SoftAssertions
    $$(".filterable-active a").findBy(text("SoftAssertions")).click();
    // поиск кода для JUnit5
    $("#wiki-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})"));
  }
}


