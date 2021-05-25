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
	if (maxSignalValue <=maxValueChecker) {
		return true;
	}
	return true;
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

int BatteryParameter::currentGenerator(int maxCurrent, int GenerateNumbers) {
	SignalUnderTest = numberGeneratorController( maxCurrent,  GenerateNumbers);
	return 0;

}
int BatteryParameter::SOCGenerator(int maxSoc, int GenerateNumbers) {
	SignalUnderTest = numberGeneratorController( maxSoc, GenerateNumbers);
	return 0;
}

bool BatteryParameter::printOnConsole(std::string parameterType) {
	std::cout << "----------------------------\n";
	std::cout << "|" << parameterType.data() << "|\n";
	std::cout << "----------------------------\n";
	std::cout << "----------------------------\n";
	for (const auto & signal : SignalUnderTest) {
		std::cout << signal << "\n";
	}
	std::cout << "----------------------------\n";

	return true;
}