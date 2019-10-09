# Test Coverage Report Using jacoco in Android
[![Build Status](https://travis-ci.org/brunogabriel/TestCoverageReport-Android.svg?branch=master)](https://travis-ci.org/brunogabriel/TestCoverageReport-Android) [![codecov](https://codecov.io/gh/brunogabriel/TestCoverageReport-Android/branch/master/graph/badge.svg)](https://codecov.io/gh/brunogabriel/TestCoverageReport-Android)

An example how to use Jacoco to generate reports in html, xml or csv format of your tests (including instrumental and unit).

## How to run

It's very simple, your reports will be generate inside build folder: **app/build/reports/jacoco**

```bash
./gradlew clean jacocoTestReport
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details