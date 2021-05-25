#define CATCH_CONFIG_MAIN
#include "test/catch.hpp"
#include"BatteryParameter.h"
#include"RandNumGenerator.h"



TEST_CASE(" Test For Battery Current Readings..."){
  
	//Arrange..
	int minCurrent = 0;
	int maxCurrent = 100;
	int GenerateNumbers = 30;
	BatteryParameter batteryparameter(new randomNumberGenerator);

	//Act...
	int expectedResult = batteryparameter.currentGenerator( maxCurrent, GenerateNumbers);

	//Assert...
	assert(expectedResult == 0);
	assert(batteryparameter.inRange(minCurrent, maxCurrent) == true);
	REQUIRE(batteryparameter.printOnConsole("currentPrinter") == true);
	REQUIRE(batteryparameter.RefreshSignalContainer()==true);
	
}
TEST_CASE(" Test For Battery Soc Readings...") {

	//Arrange..
	int minSoc = 0;
	int maxSoc = 50;
	int GenerateNumbers = 30;
	
	BatteryParameter batteryparameter(new randomNumberGenerator);
	
	//Act...
	int expectedResult = batteryparameter.SOCGenerator( maxSoc, GenerateNumbers);

	//Assert...
	assert(expectedResult == 0);
	assert(batteryparameter.inRange(minSoc, maxSoc) == true);
	REQUIRE(batteryparameter.printOnConsole("socPrinter") == true);
	REQUIRE(batteryparameter.RefreshSignalContainer() == true);
	system("pause");

}