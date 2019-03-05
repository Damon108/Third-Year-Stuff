g.list
g.list type=raster
g.list type = raster
g.list type =raster
g.list type=plant
g.list type=image
d.rast map=image@PERMANENT
d.rast map=image@PERMANENT
d.rast map=image
r.report roads units=k,p
r.report
r.report map=image@PERMANENT
r.report map=image@PERMANENT
r.report map=image@PERMANENT units=k
d.legend raster =roads
r.colors image@permanent color=wave
r.colors -help
r.colors image@permanent color=grey
r.report roads unit=c
r.report roads unit=c
r.report
r.report map=roads@PERMANENT
r.report roads unit=c
r.report roads unit=c
r.patch input=roads,rail,water,urban output=composite
r.patch input=roads,rail,water,urban output=composite
d.rast map=composite
d.rast map=composite
r.patch input=rail,water,urban,roads output=composite1
d.rast map=composite1
d.rast map=composite1
d.rast map=composite
d.legend raster = roads
d.legend raster = roads
d.legend raster=contours@PERMANENT roads
g.list type=raster
d.legend raster=contours@PERMANENT roads
d.legend raster =roads
r.patch input=rail,urban,roads,water output=composite3
d.rast map=composite3
r.patch input=rail,urban,roads,water output=composite3
r.patch input=rail,water,urban,roads output=composite1
d.rast map=composite2
d.rast map=composite1
d.rast map=composite2
d.rast map=composite1
d.rast map=composite2
d.rast map=composite3
g.remove type=raster name<composite>
g.remove type=raster namecomposite
g.remove type=raster name=composite
g.remove type=raster name=composite1
g.remove type=raster name=composite3
g.remove
g.remove type=raster
g.remove type=raster name<composite
g.list rast
g.remove type=raster name=composite3
g.list rast
g.remove type=raster name=composite3
g.remove
g.remove type=raster
g.remove type=raster
g.remove -f type=raster
g.list
g.remove
g.remove type=raster name=composite3
g.remove
g.remove -f type=raster
