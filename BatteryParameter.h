#pragma once

#include"RandNumGenerator.h"



class BatteryParameter :public randomNumberGenerator {

public:
	randomNumberGenerator * randomNumberGenerator_ObjectHandler;
	BatteryParameter(randomNumberGenerator * randomNumberGeneratorObjectHandler);

	std::vector<int> SignalCollector;
	std::vector<int> SignalUnderTest;
	std::vector<int> numberGeneratorController(int max, int GenerateNumbers);

	bool currentGenerator(int maxCurrent, int GenerateNumbers);
	bool SOCGenerator(int maxSoc, int GenerateNumbers);

	bool inRange(int minValueChecker, int maxValueChecker);
	bool printOnConsole(std::string parameterType);
	bool RefreshSignalContainer();
};

