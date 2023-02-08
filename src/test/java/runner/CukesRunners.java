package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",

                "html:target/reports/html/cucumber_API_Pet_Store_reports.html",
                "json:target/reports/json/json-reports/cucumber.json",
                "junit:target/reports/xml/xml-report/cucumber.xml",
                "rerun:target/reports/rerun.txt"
        },
        features ="src/test/resources/Features",
        glue = "stepDefinitions",

        tags = "@ApiPetStore"
)
public class CukesRunners {
}
