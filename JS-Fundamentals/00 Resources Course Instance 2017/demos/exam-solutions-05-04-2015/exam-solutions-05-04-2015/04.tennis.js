function solve (arr) {
    var result = [];
    for (var index in arr) {
        var line = arr[index];

        line = line.replace('vs.', ' vs. ');
        line = line.replace(':', ' : ');
        line = line.replace(/\s\s+/g, ' ');
        line = line.trim();

        var info = line.split(' ');

        var player1Name = info[0] + ' ' + info[1];
        var player2Name = info[3] + ' ' + info[4];

        var player1 = null, player2 = null;

        for (var i in result) {
            var current = result[i];
            if (current.name == player1Name) {
                player1 = current;
            }
            else if (current.name == player2Name) {
                player2 = current;
            }
        }

        if (player1 == null) {
            player1 = createTennisObj(player1Name);
            result.push(player1);
        }

        if (player2 == null) {
            player2 = createTennisObj(player2Name);
            result.push(player2);
        }

        var player1Sets = 0, player2Sets = 0;

        for (var i = 6; i < info.length; i++) {
            var gameResult = info[i].split('-');
            var games1 = Number(gameResult[0]);
            var games2 = Number(gameResult[1]);

            if (games1 > games2) {
                player1Sets++;
                player1.setsWon++;
                player2.setsLost++;
            }
            else {
                player2Sets++;
                player2.setsWon++;
                player1.setsLost++;
            }

            player1.gamesWon += games1;
            player2.gamesLost += games1;

            player2.gamesWon += games2;
            player1.gamesLost += games2;
        }

        if (player1Sets > player2Sets) {
            player1.matchesWon++;
            player2.matchesLost++;
        }
        else {
            player1.matchesLost++;
            player2.matchesWon++;
        }

    }

    result.sort(function(a, b) {
        if (a.matchesWon == b.matchesWon) {
            if (a.setsWon == b.setsWon) {
                var aRatio = 1, bRatio = 1;
                if (a.matchesLost != 0) {
                    aRatio = a.matchesWon / a.matchesLost;
                }
                if (b.matchesLost != 0) {
                    bRatio = b.matchesWon / b.matchesLost;
                }

                if (aRatio == bRatio) {
                    if (a.gamesWon == b.gamesWon) {
                        return a.name.localeCompare(b.name);
                    }
                    return b.gamesWon - a.gamesWon;
                }
                return bRatio - aRatio;
            }
            return b.setsWon - a.setsWon;
        }
        return b.matchesWon - a.matchesWon;
    });

    console.log(JSON.stringify(result));

    function createTennisObj(name) {
        return { name:name,
            matchesWon: 0,
            matchesLost: 0,
            setsWon: 0,
            setsLost: 0,
            gamesWon: 0,
            gamesLost: 0
        };
    }
}

var arr = [ 'Novak Djokovic vs. Roger Federer : 6-3 6-3',
    'Roger    Federer    vs.        Novak Djokovic    :         6-2 6-3',
    'Rafael Nadal vs. Andy Murray : 4-6 6-2 5-7',
    'Andy Murray vs. David Ferrer : 6-4 7-6',
    'Tomas Bedrych vs. Kei Nishikori : 4-6 6-4 6-3 4-6 5-7',
    'Grigor Dimitrov vs. Milos Raonic : 6-3 4-6 7-6 6-2',
    'Pete Sampras vs. Andre Agassi : 2-1',
    'Boris Beckervs.Andre        \t\t\tAgassi:2-1' ];

//var a = [{"name":"Andy Murray","matchesWon":2,"matchesLost":0,"setsWon":4,"setsLost":1,"gamesWon":28,"gamesLost":25},{"name":"Kei Nishikori","matchesWon":1,"matchesLost":0,"setsWon":3,"setsLost":2,"gamesWon":26,"gamesLost":25},{"name":"Grigor Dimitrov","matchesWon":1,"matchesLost":0,"setsWon":3,"setsLost":1,"gamesWon":23,"gamesLost":17},{"name":"Roger Federer","matchesWon":1,"matchesLost":1,"setsWon":2,"setsLost":2,"gamesWon":18,"gamesLost":17},{"name":"Novak Djokovic","matchesWon":1,"matchesLost":1,"setsWon":2,"setsLost":2,"gamesWon":17,"gamesLost":18},{"name":"Boris Becker","matchesWon":1,"matchesLost":0,"setsWon":1,"setsLost":0,"gamesWon":2,"gamesLost":1},{"name":"Pete Sampras","matchesWon":1,"matchesLost":0,"setsWon":1,"setsLost":0,"gamesWon":2,"gamesLost":1},{"name":"Tomas Bedrych","matchesWon":0,"matchesLost":1,"setsWon":2,"setsLost":3,"gamesWon":25,"gamesLost":26},{"name":"Milos Raonic","matchesWon":0,"matchesLost":1,"setsWon":1,"setsLost":3,"gamesWon":17,"gamesLost":23},{"name":"Rafael Nadal","matchesWon":0,"matchesLost":1,"setsWon":1,"setsLost":2,"gamesWon":15,"gamesLost":15},{"name":"David Ferrer","matchesWon":0,"matchesLost":1,"setsWon":0,"setsLost":2,"gamesWon":10,"gamesLost":13},{"name":"Andre Agassi","matchesWon":0,"matchesLost":2,"setsWon":0,"setsLost":2,"gamesWon":2,"gamesLost":4}];

solve(arr);