var Dagger = (function() {
    function Dagger(x, y, velocity) {
        this.velocity = velocity;
        this.position = new Vector2(x, y);
        this.boundingBox = new Rectangle(x, y, 32, 32);
        this.boundingBox.color = new Color(0, 255, 0, 1);
        this.animation = new Animation(32, 32, 0, 0, 1, 'resources/images/dagger.png', 1, 1, 1);
    }


    Dagger.prototype.update = function() {
        this.position.y -= this.velocity;

        this.boundingBox.x = this.position.x;
        this.boundingBox.y = this.position.y;

        this.animation.position.x = this.position.x;
        this.animation.position.y = this.position.y;
        this.animation.update();
    };

    Dagger.prototype.draw = function(ctx) {
        this.boundingBox.draw(ctx);
        this.animation.draw(ctx);
    };

    return Dagger;
}());