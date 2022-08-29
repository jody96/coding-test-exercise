import Foundation
func sosu(_ arr:[Int]) -> Bool {
    var sum = 0
    for i in arr {
        sum += i
    }
    for i in 1...sum {
        if sum % i == 0 && i != 1 && i != sum { 
            return false
        }
    }
    return true
}
func solution(_ nums:[Int]) -> Int {
    var answer = 0
    let len = nums.count
    for i in 0...(len-2) {
        for j in i+1..<len-1 {
            for k in j+1..<len {
                if sosu([nums[i], nums[j], nums[k]]) {
                    answer += 1
                }
            }
        }
    }

    return answer
}
