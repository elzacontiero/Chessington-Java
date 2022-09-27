# Chessington

A chess exercise.

Copyright © 2017 Softwire - All Rights Reserved

## Requirements

JDK from Bellsoft Liberica 17.x, which comes with JavaFX library.

## Objective

Exercise coding with tests. Write code that passes a test, write tests that are missing, refactor, repeat. 

## Implement functionality

Go through the tests and fix the ones that are failing by implementing the missing functionality.

1. Identify a failing test.
2. Identify the functionality (usually a _method_ that is failing) under test.
3. Go to that method and write code with the missing functionality.



## Task implement `getAllowedMoves`

From `git cherry-pick red-1` we receive some new tests. The tests below are correct, they are expecting (correctly) the game to behave in a certain way, but the game isn't finished. So, the tests are failing. The tests are:

- In class PawnTest:
  - `whitePawnCanMoveUpOneSquare`
  - `blackPawnCanMoveDownOneSquare`

Looking at `whitePawnCanMoveUpOneSquare` one can see that`getAllowedMoves` has a problem. It is failing to return the expected `List<Move>` object. In fact, the method is empty and needs implementation. The same applies to `blackPawnCanMoveDownOneSquare`.

Continuing implementing `getAllowedMoves` method using tests from `git cherry-pick red-2` up to `git cherry-pick red-2`.

