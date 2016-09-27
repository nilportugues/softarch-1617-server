# ProjectName

Class project for the Software Architecture 2016-17 Course, Polytechnic School, Universitat de Lleida

[![Build Status](https://travis-ci.org/UdL-EPS-SoftArch/softarch-1617-server.svg?branch=master)](https://travis-ci.org/UdL-EPS-SoftArch/softarch-1617-server/branches) [![GetBadges Game](https://udl-eps-softarch-softarch-1617-server.getbadges.io/shield/company/udl-eps-softarch-softarch-1617-server)](https://udl-eps-softarch-softarch-1617-server.getbadges.io/?ref=shield-game) <a href="https://zenhub.com"><img src="https://cdn.rawgit.com/ZenHubIO/support/master/zenhub-badge.svg"></a>

## Vision

**For** buyers and sellers **who** are interested in buying and selling second hand products.
The project **ProjectName** is a second hand marketplace **that** allows users to:

* Post ads <sup>1</sup>
* Promote ads
* Search products
* Private messaging
* Buy / Buyer counter-offer (public)
* Seller counter-offer / Sell (accept buyer counter-offer)

**Unlike** other second hand apps, our project provides negotiation features (counter-offers).

## Features per Stakeholder

| Seller                  | Buyer                  |
| ------------------------| -----------------------|
| Post ad <sup>1</sup>    | Search ads             |
| Seller counter-offer    | Buy                    |
| Sell                    | Buyer counter-offer    |
| Private message         | Private message        |
| Promote ad              | Add ad to wishlist     |
|                         | Rate purchase          |

<sup>1</sup> Including price, time limit, min. price, product type, location...

## Entities Model

![Entities Model Diagram](http://g.gravizo.com/g?
@startuml;
class Advertisement {;
    Seller seller;
    List<Picture> pictures;
    String location;
    Time time;
};
Advertisement "many" -up- "1" Seller;
Advertisement "1" -down- "many" Picture;
class Picture;
class User;
class Seller extends User {;
    List<Advertisement> sells;
};
class Buyer extends User {;
    List<Advertisement> whishes;
};
class Purchase {;
    Buyer purchaser;
    Advertisement product;
    Time time;
};
Purchase "many" -up- "1" Buyer;
Purchase "0..1" -right- "1" Advertisement;
class Offer {;
    Advertisement about;
    Time time;
};
class SellerOffer extends Offer {;
    Seller agent;
};
SellerOffer "1" -left- "1" Advertisement;
class BuyerCounterOffer extends Offer {;
    Buyer agent;
    SellerOffer respondsTo;
};
BuyerCounterOffer "1" --> "1" SellerOffer;
class SellerCounterOffer extends SellerOffer {;
    BuyerCounterOffer respondsTo;
};
SellerCounterOffer "1" --> "1" BuyerCounterOffer;
class PrivateMessage {;
    User sender;
    User receiver;
};
PrivateMessage "many" -left- "2" User;
@enduml
)
