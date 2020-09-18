package test.stackqueue;

import java.util.Stack;

public class CraneDoll {
  public static void main(String[] args) {
    int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
    int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
    // result 4

    int solution = solution2(board, moves);
    System.out.println(solution);
  }

  private static int solution(int[][] board, int[] moves) {
    int[] countArray = new int[board.length];
    int moveIndex = 0;
    int result = 0;
    Stack<Integer> stack = new Stack<>();
    while (moveIndex < moves.length) {
      for (int i = 0; i < board.length; i++) {

        int value = board[i][moves[moveIndex] - 1];
        if (value != 0) {
          // countArray 에 증가 값이 있으면 i 를 증가 시켜줘야 한다.
          int count = countArray[moves[moveIndex] - 1];
          if (count > 0) {
            // 범위를 벗어날 경우 value 값이 없으므로 0
            if (i + count >= board.length) {
              value = 0;
            } else {
              value = board[i + count][moves[moveIndex] - 1];
            }
          }
          // 스택에 담는다.
          if (value != 0) {
            if (stack.isEmpty() || stack.peek() != value) {
              stack.add(value);
            } else {
              stack.pop();
              result++;
            }
          }

          countArray[moves[moveIndex] - 1]++;
          moveIndex++;
          break;
        }
      }
    }

    return result * 2;
  }

  private static int solution2(int[][] board, int[] moves) {
    int result = 0;
    Stack<Integer> stack = new Stack<>();
    for (int move : moves) {
      for (int i = 0; i < board.length; i++) {
        int boardValue = board[i][move - 1];
        if (boardValue != 0) {
          if (stack.isEmpty()) {
            stack.push(boardValue);
            board[i][move - 1] = 0;
            break;
          }
          if (boardValue == stack.peek()) {
            stack.pop();
            result += 2;
          } else {
            stack.push(boardValue);
          }
          board[i][move - 1] = 0;
          break;
        }
      }
    }

    return result;
  }
}
