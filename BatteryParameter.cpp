#include<iostream>
#include<algorithm>
#include"BatteryParameter.h"


BatteryParameter::BatteryParameter(randomNumberGenerator * randomNumberGeneratorObjectHandler) {
	randomNumberGenerator_ObjectHandler = randomNumberGeneratorObjectHandler;
}

bool BatteryParameter::inRange(int minValueChecker, int maxValueChecker) {
	std::sort(SignalUnderTest.begin(), SignalUnderTest.end());
	int minSignalValue = SignalUnderTest.front();
	int maxSignalValue = SignalUnderTest.back();
	if (maxSignalValue <=maxValueChecker && minValueChecker <= minSignalValue) {
		return true;
	}
	return false;
}

std::vector<int> BatteryParameter::numberGeneratorController(int max, int GenerateNumbers) {
	while (GenerateNumbers != 0) {
		SignalCollector.push_back(randomNumberGenerator_ObjectHandler->randNGenerator(max));
		GenerateNumbers--;
	}
	return SignalCollector;
}

bool BatteryParameter::RefreshSignalContainer() {
	SignalCollector.erase(SignalCollector.begin(), SignalCollector.end());
	return true;
}

bool BatteryParameter::currentGenerator(int maxCurrent, int GenerateNumbers) {
	SignalUnderTest = numberGeneratorController( maxCurrent,  GenerateNumbers);
	ToConsole["currentPrinter"] = SignalUnderTest;
	return true;

}
bool BatteryParameter::SOCGenerator(int maxSoc, int GenerateNumbers) {
	SignalUnderTest = numberGeneratorController( maxSoc, GenerateNumbers);
	ToConsole["socPrinter"] = SignalUnderTest;
	return true;
}

bool BatteryParameter::printOnConsole(std::string parameterType, int GenerateNumbers) {
	std::cout << "----------------------------\n";
	std::cout << "|" << parameterType.data() << "|\n";
	std::cout << "----------------------------\n";
	std::cout << "----------------------------\n";
	for (int readings = 0; readings < GenerateNumbers; ++readings) {
		std::cout << ToConsole["currentPrinter"][readings] <<"      "<< ToConsole["socPrinter"][readings] << "\n";
	}
	std::cout << "----------------------------\n";

	return true;
}