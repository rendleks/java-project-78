### Hexlet tests and linter status:
[![Actions Status](https://github.com/rendleks/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/rendleks/java-project-78/actions) [![Quality gate status](https://sonarcloud.io/api/project_badges/measure?project=rendleks_java-project-71&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=rendleks_java-project-71) [![Bugs](https://sonarcloud.io/api/project_badges/measure?project=rendleks_java-project-71&metric=bugs)](https://sonarcloud.io/summary/new_code?id=rendleks_java-project-71) [![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=rendleks_java-project-71&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=rendleks_java-project-71) [![Coverage](https://sonarcloud.io/api/project_badges/measure?project=rendleks_java-project-71&metric=coverage)](https://sonarcloud.io/summary/new_code?id=rendleks_java-project-71) [![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=rendleks_java-project-71&metric=duplicated_lines_density)](https://sonarcloud.io/summary/new_code?id=rendleks_java-project-71)


## Data validation

# Validator

Проект, направленный на прокачку проектирования архитектуры в объектно-ориентированном стиле. Здесь вам понадобится применять практически все, чему вы научились в курсах по ООП: проектирование структуры классов, композиция объектов, возможно наследование и, обязательно, fluent-интерфейс.

## Возможности

- **StringSchema** — валидация строк: `required()`, `minLength(n)`, `contains(substring)`
- **NumberSchema** — валидация чисел: `required()`, `positive()`, `range(min, max)`
- **MapSchema** — валидация map: `required()`, `sizeof(n)`, `shape(schemas)` — вложенная валидация полей по своим схемам

## Установка

Проект собирается с помощью Gradle:

```bash
./gradlew build
```

## Пример использования

```java
var v = new Validator();
var schema = v.map();

schema.required();
schema.sizeof(2);

Map<String, BaseSchema<String>> schemas = new HashMap<>();
schemas.put("firstName", v.string().required().contains("ya"));
schemas.put("lastName", v.string().required().contains("ov"));
schema.shape(schemas);

Map<String, String> actual = new HashMap<>();
actual.put("firstName", "Maya");
actual.put("lastName", "Krasnova");

schema.isValid(actual); // true
```

## Возможности

- **StringSchema** — валидация строк: `required()`, `minLength(n)`, `contains(substring)`
- **NumberSchema** — валидация чисел: `required()`, `positive()`, `range(min, max)`
- **MapSchema** — валидация map: `required()`, `sizeof(n)`, `shape(schemas)` — вложенная валидация полей по своим схемам

## Установка

Проект собирается с помощью Gradle:

```bash
./gradlew build
```

## Пример использования

```java
var v = new Validator();
var schema = v.map();

schema.required();
schema.sizeof(2);

Map<String, BaseSchema<String>> schemas = new HashMap<>();
schemas.put("firstName", v.string().required().contains("ya"));
schemas.put("lastName", v.string().required().contains("ov"));
schema.shape(schemas);

Map<String, String> actual = new HashMap<>();
actual.put("firstName", "Maya");
actual.put("lastName", "Krasnova");

schema.isValid(actual); // true
```

## Технологии

- Java 17+
- Gradle
- JUnit 5 (тестирование)

## Package

```
hexlet.code
```
