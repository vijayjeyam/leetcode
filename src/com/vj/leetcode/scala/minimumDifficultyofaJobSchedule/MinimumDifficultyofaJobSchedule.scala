package com.vj.leetcode.scala.minimumDifficultyofaJobSchedule

import com.vj.leetcode.scala.TestMixin


object Solution {

  def getRemainingHardest(jobDifficulty: Array[Int]):Array[Int] = {
    val remainingHard = Array.ofDim[Int](jobDifficulty.length)
    var hardest = 0
    for(ind <- remainingHard.length-1 to 0 by -1){
      hardest = Math.max(hardest,jobDifficulty(ind))
      remainingHard(ind) = hardest
    }
    remainingHard
  }

  def minDifficulty(jobDifficulty: Array[Int], d: Int): Int = {
    if(jobDifficulty.length < d) {
      return -1
    }
    val numJobs = jobDifficulty.length
    val remHardest = getRemainingHardest(jobDifficulty)
    val memo = Array.tabulate(d, numJobs)((_, _) => -1)

    def dp(indexSt: Int, day: Int): Int = {
      if (day == d) {
        return remHardest(indexSt)
      }
      if (memo(day)(indexSt) == -1) {
        var hardest = 0
        var goodSolution = Int.MaxValue
        for (ind <- indexSt until (numJobs - d + day)) {
            hardest = Math.max(hardest,jobDifficulty(ind))
            goodSolution = Math.min(goodSolution,hardest+dp(ind+1,day+1))
        }
        memo(day)(indexSt) = goodSolution
      }
      memo(day)(indexSt)
    }

    dp(0,1)
  }
}