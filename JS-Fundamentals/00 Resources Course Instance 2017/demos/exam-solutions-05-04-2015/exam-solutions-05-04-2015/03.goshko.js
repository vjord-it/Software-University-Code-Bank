function solve(arr) {
    var field = [];
    var inputDirections = arr[0];
    var directions = inputDirections.split(', ');

    for (var i = 1; i < arr.length; i++) {
        var row = arr[i].split(', ');

        field.push(row);
    }

    var currentCol = 0, currentRow = 0;
    var visitedCells = [];
    var wallHits = 0, carrots = 0, cabbage = 0, lettuce = 0, turnip = 0;

    for (var index in directions) {
        var direction = directions[index];
        var isWallHit = false;

        switch (direction) {
            case 'left':
                currentCol--;
                if (currentCol < 0) { currentCol = 0; isWallHit = true; }
                break;
            case 'right':
                currentCol++;
                if (currentCol >= field[0].length) { currentCol = field[0].length - 1; isWallHit = true; }
                break;
            case 'up':
                currentRow--;
                if (currentRow < 0) { currentRow = 0; isWallHit = true; }
                break;
            case 'down':
                currentRow++;
                if (currentRow >= field.length) { currentRow = field.length - 1; isWallHit = true; }
                break;
        }

        if (isWallHit) {
            wallHits++;
        }
        else {
            var cell = field[currentRow][currentCol];

            while (cell.indexOf('{!}') != -1) {
                carrots++;
                cell = cell.replace('{!}', '@');
            }
            while (cell.indexOf('{*}') != -1) {
                cabbage++;
                cell = cell.replace('{*}', '@');
            }
            while (cell.indexOf('{&}') != -1) {
                lettuce++;
                cell = cell.replace('{&}', '@');
            }
            while (cell.indexOf('{#}') != -1) {
                turnip++;
                cell = cell.replace('{#}', '@');
            }

            visitedCells.push(cell);
        }
    }

    console.log('{"&":'+lettuce+',"*":'+cabbage+',"#":'+turnip+',"!":'+carrots+',"wall hits":'+wallHits+'}');
    if (visitedCells.length == 0) {
        console.log('no');
    }
    else {
        console.log(visitedCells.join('|'));
    }
}

var arr = [ 'right, up, up, down',
    'asdf, as{#}aj{&}d{#}asd, kjldk{}fdffd, jdflk{#}jdfj',
    'tr{X}yrty, zxx{*}zxc, mncvnvcn, popipoip',
    'poiopipo, nmf{X}d{X}ei, mzoijwq, omcxzne' ];
//arr = [ 'up, right, left, down', 'as{!}xnk' ];
solve(arr);
