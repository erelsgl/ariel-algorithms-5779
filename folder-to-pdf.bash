for folder in $@; do
    echo $folder
    cd $folder
    ../convert-to-pdf.bash
    cd ..
done

