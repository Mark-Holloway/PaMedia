package weather;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WeatherAPI {

	static String today;
	static String tommorrow;
	static String locationID;
	static String locationName;

	@Test(priority = 1)
	public void calculate_date() {

		// Get and format the dates to pass to the API

		Calendar calendar = Calendar.getInstance();
		today = new SimpleDateFormat("yyyy/MM/dd").format(calendar.getTime());

		calendar.add(Calendar.DATE, 1);
		tommorrow = new SimpleDateFormat("yyyy/MM/dd").format(calendar.getTime());

	}

	@Test(priority = 2)
	public void weather_location_parameters() {

		// Location Parameters for API Tests

		locationID = "30720";
		locationName = "nottingham";

	}

	@Test(priority = 3)
	public void weather_api_existing_test() {

		// Test the API for Tommorrows Weather Data

		System.out.println("Tommorrows date is - " + tommorrow);
		System.out.println("Weather locations is - " + locationID);
		System.out.println("Weather check current features");

		baseURI = "https://www.metaweather.com/api";

		given().

				get("/api/location/" + locationID + "/" + tommorrow).

				then().statusCode(200).log().headers().log().body();

	}

	@Test(priority = 4)
	public void weather_api_feature_test() {

		// Test the Latitude and Longitude features

		System.out.println("Weather locations is - " + locationName);
		System.out.println("Weather check new features");

		System.out.println("Weather check by Latitude / Longditude");

		baseURI = "https://www.metaweather.com/api";

		given().

				get("/api/location/search/?lattlong=52.949219,-1.143920").

				then().statusCode(200).log().headers().log().body();

		// Test the API by Location Name features
		System.out.println("Weather check by name");

		baseURI = "https://www.metaweather.com/api";

		given().

				get("/api/location/search/?query=locationName").

				then().statusCode(200).log().headers().log().body();

	}

}
