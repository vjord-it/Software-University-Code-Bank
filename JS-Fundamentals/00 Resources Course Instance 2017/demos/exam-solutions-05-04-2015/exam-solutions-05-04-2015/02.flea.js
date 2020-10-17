function solve(arr) {
    var maxJumps = Number(arr[0]);
    var fieldLength = Number(arr[1]);
    var players = [];

    for (var i = 2; i < arr.length; i++) {
        var player = arr[i];
        var playerData = player.split(', ');
        playerData[1] = Number(playerData[1]);
        playerData.push(0);

        players.push(playerData);
    }

    var winnerIndex = -1;

    for (var jump = 0; jump < maxJumps; jump++) {
        for (var index in players) {
            var player = players[index];

            player[2] += player[1];

            if (player[2] >= (fieldLength - 1)) {
                player[2] = fieldLength - 1;
                winnerIndex = index;
                break;
            }
        }

        if (winnerIndex != -1) {
            break;
        }
    }

    console.log(Array(fieldLength+1).join('#'));
    console.log(Array(fieldLength+1).join('#'));

    for (var index in players) {
        var playerRow = "";
        playerRow += Array(players[index][2]+1).join('.');
        playerRow += players[index][0][0].toUpperCase();
        playerRow += Array(fieldLength-players[index][2]).join('.');
        console.log(playerRow);
    }
    console.log(Array(fieldLength+1).join('#'));
    console.log(Array(fieldLength+1).join('#'));

    var winner = "";

    if (winnerIndex != -1) {
        winner = players[winnerIndex][0];
    }
    else {
        var maxDist = 0;
        for (var index in players) {
            if (players[index][2] >= maxDist) {
                winner = players[index][0];
                maxDist = players[index][2];
            }
        }
    }

    console.log("Winner: " + winner);
}

var arr = [ '10', '19', 'angel, 9', 'Boris, 10', 'Georgi, 3', 'Dimitar, 7' ];
arr = [ '3', '5', 'cura, 1', 'Pepi, 1', 'UlTraFlee, 1', 'BOIKO, 1' ];

solve(arr);