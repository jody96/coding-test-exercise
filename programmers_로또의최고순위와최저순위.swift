import Foundation

func solution(_ lottos:[Int], _ win_nums:[Int]) -> [Int] {
    var correct = 0
    var zero_count = 0
    var answer = [Int](repeating: 0, count: 2)
    for i in 0..<6 {
        if lottos[i] == 0 {
            zero_count += 1
            continue
        }
        else if win_nums.contains(lottos[i]) {
            correct += 1
        }
    }
    
    answer[0] = 7 - (correct + zero_count)
    answer[1] = 7 - (correct)
    if answer[1] > 6 {
        answer[1] = 6
    }
    if answer[0] > 6 {
        answer[0] = 6
    }
    
    return answer
}
