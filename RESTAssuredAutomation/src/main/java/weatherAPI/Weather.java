package weatherAPI;

import org.apache.groovy.parser.antlr4.util.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Weather {

	static String today;
	static String tommorrow;
	static String locationID;
	static String locationName;
	static String locationDate;
	static String fetchDate;

	@Test(priority = 1)
	public void calculate_date() {

		Calendar calendar = Calendar.getInstance();
		today = new SimpleDateFormat("yyyy/MM/dd").format(calendar.getTime());

		calendar.add(Calendar.DATE, 1);
		tommorrow = new SimpleDateFormat("yyyy/MM/dd").format(calendar.getTime());

	}

	@Test(priority = 2)
	public void weather_location_parameters() {

		// Location name and Location ID can be changed here

		locationID = "30720";
		locationName = "nottingham";

		// Enter the required Date else it will default to Tomorrow
		// Format = yyyy/MM/dd example: locationDate = "2021/08/22"

		locationDate = "";

		if (StringUtils.isEmpty(locationDate)) {

			fetchDate = tommorrow;

		} else {

			fetchDate = locationDate;

		}

	}

	@Test(priority = 3)
	public void weather_api_existing_test() {

		// Test to check other

		System.out.println("Date is - " + fetchDate);
		System.out.println("Weather locations is - " + locationID);
		System.out.println("Weather check current features");

		baseURI = "https://www.metaweather.com/api";

		given().

				get("/api/location/" + locationID + "/" + fetchDate).

				then().statusCode(200).log().headers().log().body();

	}

	@Test(priority = 4)
	public void weather_api_feature_test() {

		System.out.println("Weather locations is - " + locationName);
		System.out.println("Weather check new features");

		// Test by Latt - Long
		System.out.println("Weather check by Latitude / Longditude");

		baseURI = "https://www.metaweather.com/api";

		given().

				get("/api/location/search/?lattlong=52.949219,-1.143920").

				then().statusCode(200).log().headers().log().body();

		// Test by search Name
		System.out.println("Weather check by name");

		baseURI = "https://www.metaweather.com/api";

		given().

				get("/api/location/search/?query=locationName").

				then().statusCode(200).log().headers().log().body();

	}

}
