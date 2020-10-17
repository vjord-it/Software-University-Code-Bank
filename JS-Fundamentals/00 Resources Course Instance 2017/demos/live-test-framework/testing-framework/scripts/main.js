var canvas = document.getElementById('canvas');
var ctx = canvas.getContext('2d');

var input = new Input();
attachListeners(input);

var balloons = [];
balloons.push(new Balloon(400, 80));
balloons.push(new Balloon(100, 80));
balloons.push(new Balloon(200, 80));
balloons.push(new Balloon(300, 80));
balloons.push(new Balloon(500, 80));
balloons.push(new Balloon(600, 80));
balloons.push(new Balloon(700, 80));

var previousX = input.mousePosition.x;


var player = new Player(canvas.clientWidth / 2, 350, 18 * 5 , 24.75 * 5);

function update() {
    tick();
    draw(ctx);
    requestAnimationFrame(update);
}

function tick() {
    if(input.mousePosition.x - previousX > 0) {
        player.animation.setRow(2);
    } else if (input.mousePosition.x - previousX < 0) {
        player.animation.setRow(0);
    }

    player.daggers.forEach(function(dagger) {
        balloons.forEach(function(balloon) {
            if(dagger.boundingBox.intersects(balloon.boundingBox)) {
                balloon.popBalloon();
            }
        });
    });


    previousX = input.mousePosition.x;
    player.position.x = input.mousePosition.x - GetLeft(canvas) - 50;
    player.update();
    balloons.forEach(function(b) {
        var dead = b.update();
        if(dead) {
            balloons.remove(b);
        }
    })
}

function  draw(ctx) {
    ctx.clearRect(0, 0, canvas.clientWidth, canvas.clientHeight);

    player.draw(ctx);
    balloons.forEach(function(b) {
        b.draw(ctx);
    })
}

update();