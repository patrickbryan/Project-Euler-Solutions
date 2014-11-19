function solution()
    sum = 0
    for x in 3:999
        if  mod(x, 3) == 0 || mod (x, 5) == 0
            sum += x
        end
    end
    println(sum)
end