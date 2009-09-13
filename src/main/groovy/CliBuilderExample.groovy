def cli = new CliBuilder(usage: 'groovy CliBuilderExample -d "dir" ')

cli.d(argName:'dir', args:1, required:true, 'Directory to Search, REQUIRED')

def opt = cli.parse(args)
if (opt)
	println "the directory is ${opt.d}"