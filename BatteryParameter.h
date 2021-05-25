#pragma once

#include"RandNumGenerator.h"



class BatteryParameter :public randomNumberGenerator {

public:
	randomNumberGenerator * randomNumberGenerator_ObjectHandler;
	BatteryParameter(randomNumberGenerator * randomNumberGeneratorObjectHandler);

	std::vector<int> SignalCollector;
	std::vector<int> SignalUnderTest;
	std::vector<int> numberGeneratorController(int max, int GenerateNumbers);

	int currentGenerator(int maxCurrent, int GenerateNumbers);
	int SOCGenerator(int maxSoc, int GenerateNumbers);

	bool inRange(int minValueChecker, int maxValueChecker);
	bool printOnConsole(std::string parameterType);
	bool RefreshSignalContainer();
};

