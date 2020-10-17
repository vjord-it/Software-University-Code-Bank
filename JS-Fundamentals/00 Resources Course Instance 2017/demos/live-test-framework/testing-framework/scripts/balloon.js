var  Balloon = (function() {
    function  Balloon(x, y) {
        this.x = x;
        this.y = y;
        this.boundingBox = new Rectangle(x, y, 59, 68);
        this.boundingBox.color = new Color(255,0,0,1);
        this.animation = new Animation(59, 68, 0, 0, 1, 'resources/images/balloon.png', 7, 1, 1);
    }


    Balloon.prototype.update = function() {
        if(this.animation.column == 6) {
            return true;
        }
        this.boundingBox.x = this.x;
        this.boundingBox.y = this.y;

        this.animation.position.x = this.x;
        this.animation.position.y = this.y;
        this.animation.update();
    };

    Balloon.prototype.draw = function(ctx) {

        this.boundingBox.draw(ctx);
        this.animation.draw(ctx);
    };

     Balloon.prototype.popBalloon = function() {
         this.animation.setLimit(7);
         this.animation.columns = 7;
    };

    return  Balloon;
}());