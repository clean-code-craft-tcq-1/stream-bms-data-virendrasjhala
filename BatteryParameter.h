#pragma once
#include<map>
#include"RandNumGenerator.h"



class BatteryParameter :public randomNumberGenerator {

public:
	randomNumberGenerator * randomNumberGenerator_ObjectHandler;
	BatteryParameter(randomNumberGenerator * randomNumberGeneratorObjectHandler);

	std::vector<int> SignalCollector;
	std::vector<int> SignalUnderTest;
	std::map<std::string, std::vector<int>> ToConsole;
	std::vector<int> numberGeneratorController(int max, int GenerateNumbers);

	bool currentGenerator(int maxCurrent, int GenerateNumbers);
	bool SOCGenerator(int maxSoc, int GenerateNumbers);

	bool inRange(int minValueChecker, int maxValueChecker);
	bool printOnConsole(std::string parameterType, int GenerateNumbers);
	bool RefreshSignalContainer();
};

