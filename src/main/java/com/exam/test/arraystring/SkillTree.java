package com.exam.test.arraystring;

public class SkillTree {
  public static void main(String[] args) {
    String skill = "CBD";
    String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA", "AQWER"};

    int solution = solution2(skill, skill_trees);
    System.out.println(solution);

  }

  private static int solution(String skill, String[] skill_trees) {
    int answer = 0;
    for (int i = 0; i < skill_trees.length; i++) {
      int skillIndex = 0;
      boolean flag = true;

      int treeIdxLength = skill_trees[i].length();
      for (int j = 0; j < treeIdxLength; j++) {

        for (int k = skillIndex; k < skill.length(); k++) {
          if (skill.charAt(k) == skill_trees[i].charAt(j)) {
            if (k != skillIndex) {
              flag = false;
            } else {
              skillIndex++;
            }

          }
        }
      }

      if (flag == true) {
        answer++;
      }
    }
    return answer;
  }

  private static int solution2(String skill, String[] skill_trees) {
    int answer = 0;
    for (int i = 0; i < skill_trees.length; i++) {
      String skilltree = skill_trees[i];
      int index = 0;
      boolean flag = true;
      for (int j = 0; j < skilltree.length(); j++) {
        for (int k = index; k < skill.length(); k++) {
          if (skill.charAt(k) == skilltree.charAt(j)) {

            if (k != index) {
              flag = false;
            } else {
              index++;
            }
          }
        }

      }
      if (flag == true) {
        answer++;
      }
    }
    return answer;
  }
}
