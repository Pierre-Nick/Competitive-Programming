function pidgeyCalc(pidgey, candy) {
    var expSum = 0;
    if (candy < 12) {
        var candy_needed = 12 - candy;

        if (pidgey > candy_needed) {
            candy += candy_needed;
            pidgey -= candy_needed;
        }
        else {
            return expSum;
        }
    }

    while (candy >= 12 && pidgey > 0) {
        expSum += 500;
        candy -= 11;
        pidgey -= 1;
        if (candy < 12) {
            var candy_needed = 12 - candy;
            if (pidgey > candy_needed) {
                candy += candy_needed;
                pidgey -= candy_needed;
            }
            else {
                break;
            }
        }
    }

    return expSum;
}