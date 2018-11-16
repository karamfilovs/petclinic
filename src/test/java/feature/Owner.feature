Feature: This is feature file for all Owner tests

  @test
  Scenario: Add new owner
    Given I am at Petclinic Owners page
    When I create owner with name "name" address "add"
    Then Owner Information page header text should be  "expected text"

