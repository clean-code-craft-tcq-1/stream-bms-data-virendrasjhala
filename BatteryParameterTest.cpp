#define CATCH_CONFIG_MAIN
#include "test/catch.hpp"
#include"BatteryParameter.h"
#include"RandNumGenerator.h"



TEST_CASE(" Test For Battery Current Readings..."){
  
	//Arrange..
	int minCurrent = 0;    //cureent...
	int maxCurrent = 100;
	
	int minSoc = 0;        //Soc...
	int maxSoc = 50;

	int GenerateNumbers = 30;
	BatteryParameter batteryparameter(new randomNumberGenerator);

	//Act...
	bool currentexpectedResult = batteryparameter.currentGenerator( maxCurrent, GenerateNumbers);

	//Assert...
	assert(currentexpectedResult == true);
	REQUIRE(batteryparameter.RefreshSignalContainer() == true);
	assert(batteryparameter.inRange(minCurrent, maxCurrent) == true);

	//Act...
	bool socexpectedResult = batteryparameter.SOCGenerator(maxSoc, GenerateNumbers);

	//Assert...
	assert(socexpectedResult == true);
	assert(batteryparameter.inRange(minSoc, maxSoc) == true);
	REQUIRE(batteryparameter.printOnConsole("Current and Soc", GenerateNumbers) == true);
	
}
