var Player = (function() {
    function Player(x, y, width, height) {
        this.position = new Vector2(x, y);
        this.width = width;
        this.height = height;
        this.daggers = [];
        this.shot = false;
        this.animation = new Animation(width, height, 0, 0, 10, 'resources/images/indianec.png', 10, 5, 2);
    }


    Player.prototype.update = function() {
        if(input.mouseIsDown) {
            this.shoot();
        } else {
            this.shot = false;
        }


        this.animation.update();
        this.animation.position.x = this.position.x;
        this.animation.position.y = this.position.y;
    };

    Player.prototype.draw = function(ctx) {
        this.animation.draw(ctx);

        this.daggers.forEach(function(dag) {
            dag.update();
            dag.draw(ctx);
        });
    };

    Player.prototype.shoot = function () {
        if(!this.shot) {
            this.daggers.push(new Dagger(
                this.position.x + this.width / 2,
                this.position.y - 32,
                1));
            this.shot = true;
        }
    };

    return Player;
}());